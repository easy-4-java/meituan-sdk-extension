"""校验实际生效的私有仓库发布配置，防止扩展插件接管 deploy 生命周期。"""

from pathlib import Path
import subprocess
import tempfile
import unittest
from urllib.parse import urlsplit
import xml.etree.ElementTree as ET


ROOT = Path(__file__).resolve().parents[1]
NS = {"m": "http://maven.apache.org/POM/4.0.0"}


class ReleaseProfileTest(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        with tempfile.TemporaryDirectory(prefix="meituan-release-profile-") as directory:
            output = Path(directory) / "effective-pom.xml"
            result = subprocess.run(
                [str(ROOT / "mvnw"), "-B", "--no-transfer-progress", "-Prelease",
                 "help:effective-pom", "-Doutput=" + str(output)],
                cwd=ROOT, capture_output=True, text=True, timeout=180,
            )
            if result.returncode:
                raise AssertionError("Cannot resolve release profile:\n" + result.stdout + result.stderr)
            cls.pom = ET.parse(output).getroot()
        cls.plugins = {
            plugin.findtext("m:artifactId", namespaces=NS): plugin
            for plugin in cls.pom.findall("m:build/m:plugins/m:plugin", NS)
        }

    def test_standard_deploy_owns_publication(self):
        self.assertIn("maven-deploy-plugin", self.plugins)
        self.assertNotIn("nexus-staging-maven-plugin", self.plugins)
        self.assertNotIn("central-publishing-maven-plugin", self.plugins)
        extensions = [name for name, plugin in self.plugins.items()
                      if plugin.findtext("m:extensions", namespaces=NS) == "true"]
        self.assertEqual([], extensions, "Private deployment must use the standard Maven lifecycle")

    def test_tests_and_release_attachments_remain_enabled(self):
        for name in ("maven-enforcer-plugin", "maven-surefire-plugin", "maven-source-plugin",
                     "maven-javadoc-plugin", "maven-gpg-plugin"):
            self.assertIn(name, self.plugins)
        surefire = self.plugins["maven-surefire-plugin"]
        for option in ("skip", "skipTests"):
            self.assertNotEqual("true", surefire.findtext("m:configuration/m:" + option, namespaces=NS))
        required_goals = {"maven-enforcer-plugin": "enforce", "maven-source-plugin": "jar-no-fork",
                          "maven-javadoc-plugin": "jar", "maven-gpg-plugin": "sign"}
        for name, goal in required_goals.items():
            goals = [node.text for node in self.plugins[name].findall("m:executions/m:execution/m:goals/m:goal", NS)]
            self.assertIn(goal, goals, name)
        javadoc = self.plugins["maven-javadoc-plugin"]
        for option in ("failOnError", "failOnWarnings"):
            self.assertEqual("true", javadoc.findtext("m:configuration/m:" + option, namespaces=NS))
        self.assertEqual("all", javadoc.findtext("m:configuration/m:doclint", namespaces=NS))
        self.assertNotEqual("true", self.plugins["maven-gpg-plugin"].findtext("m:configuration/m:skip", namespaces=NS))

    def test_distribution_targets_aliyun(self):
        for kind in ("repository", "snapshotRepository"):
            repository = self.pom.find("m:distributionManagement/m:" + kind, NS)
            self.assertIsNotNone(repository)
            self.assertTrue(repository.findtext("m:id", namespaces=NS))
            self.assertEqual("packages.aliyun.com", urlsplit(repository.findtext("m:url", namespaces=NS)).hostname)


if __name__ == "__main__":
    unittest.main()
