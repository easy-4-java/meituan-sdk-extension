"""核验本地派生 SDK 与最终 Boot JAR 的来源、验证命名空间和签名字节码。"""
import argparse
import hashlib
import io
import json
from pathlib import Path
from zipfile import ZipFile


def verify(original_sdk, sdk_artifact, application_jar):
    """读取三个本地构件，检查单一 SDK 来源及最小范围的验证转换。"""
    with ZipFile(original_sdk) as original, ZipFile(sdk_artifact) as derived:
        classes = {name for name in original.namelist() if name.endswith('.class')}
        derived_classes = {name for name in derived.namelist() if name.endswith('.class')}
        assert classes <= derived_classes, '扩展构件缺失官方 SDK 类'
        for name in derived_classes:
            assert b'javax/validation' not in derived.read(name) and b'javax.validation' not in derived.read(name), name
        changed = []
        for name in sorted(classes):
            before, after = original.read(name), derived.read(name)
            assert b'javax/validation' not in after and b'javax.validation' not in after, name
            if before != after:
                assert b'javax/validation' in before or b'javax.validation' in before, name
                changed.append(name)
        assert changed, '没有实际转换验证引用'
        signer = 'com/meituan/sdk/internal/utils/SignerUtil.class'
        assert original.read(signer) == derived.read(signer), '签名字节码被修改'
        validation = 'com/meituan/sdk/internal/utils/ValidationUtil.class'
        assert b'jakarta/validation' in derived.read(validation), '官方校验器未转换'
    sources = []
    with ZipFile(application_jar) as boot:
        assert validation not in {n.removeprefix('BOOT-INF/classes/') for n in boot.namelist()
                                  if n.startswith('BOOT-INF/classes/')}, '应用内出现同名 SDK 覆盖类'
        libs = [n for n in boot.namelist() if n.startswith('BOOT-INF/lib/') and n.endswith('.jar')]
        assert not any('/MtOpJavaSDK-' in n for n in libs), '应用仍打包原始 SDK'
        assert not any('/validation-api-' in n or '/javax.el-' in n for n in libs), '旧 javax 验证运行库残留'
        assert any('/jakarta.validation-api-' in n for n in libs), '缺少 Jakarta Validation API'
        validators = [n for n in libs if '/hibernate-validator-' in n]
        assert len(validators) == 1 and '/hibernate-validator-6.' not in validators[0], validators
        for name in libs:
            with ZipFile(io.BytesIO(boot.read(name))) as nested:
                if validation in nested.namelist():
                    sources.append(name)
                    assert boot.read(name) == Path(sdk_artifact).read_bytes(), '运行 SDK 与验证构件不一致'
        assert len(sources) == 1 and 'meituan-sdk-extension-' in sources[0], sources
    return {'status': 'passed', 'official_classes': len(classes), 'validation_classes_transformed': len(changed),
            'signer_bytecode_unchanged': True, 'runtime_sdk': sources[0],
            'original_sdk_sha256': hashlib.sha256(Path(original_sdk).read_bytes()).hexdigest(),
            'sdk_sha256': hashlib.sha256(Path(sdk_artifact).read_bytes()).hexdigest(),
            'application_sha256': hashlib.sha256(Path(application_jar).read_bytes()).hexdigest()}


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--original-sdk', required=True, type=Path)
    parser.add_argument('--sdk-artifact', required=True, type=Path)
    parser.add_argument('--application-jar', required=True, type=Path)
    args = parser.parse_args()
    print(json.dumps(verify(args.original_sdk, args.sdk_artifact, args.application_jar), indent=2))
