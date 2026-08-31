##一、环境说明
美团技术服务合作中心Java版本SDK，支持jdk 1.8及以上版本。

##二、引入方式
下载jar包，添加到项目依赖中。SDK运行时需要依赖几个第三方库，如果您使用maven的话，直接添加以下依赖到pom.xml即可:
```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.1.0.Final</version>
</dependency>
<dependency>
    <groupId>org.glassfish</groupId>
    <artifactId>javax.el</artifactId>
    <version>3.0.1-b11</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
```
> 若您的项目中已包含上面的依赖，则忽略。

## 三、调用示例

以接口[门店本地验券历史](https://developer.meituan.com/docs/api/tuangou-coupon-queryLocalListByDate) 为例， DK提供了类***CouponQueryLocalListByDateRequest***来封装请求，您调用此接口的代码可以参考：

```java
Long developerId = 1111L;
String signKey = "xxxx";
String appAuthToken = "xxxxxxxxxxxxx";
//构造meituanClient，推荐使用单例方式，一个develoepr只使用一个实例
MeituanClient meituanClient = DefaultMeituanClient.builder(developerId, signKey).build();

//准备请求参数
CouponQueryLocalListByDateRequest request = new CouponQueryLocalListByDateRequest();
request.setDate("2020-12-15");
request.setOffset(0);
request.setLimit(10);

try {
  //发起接口调用
  MeituanResponse<CouponQueryLocalListByDateResponse> response = meituanClient.invokeApi(request, appAuthToken);
  //判断是调用是否成功
  if (response.isSuccess()) {
    //调用成功，通过getData获取接口响应数据
    CouponQueryLocalListByDateResponse localListByDateResponse = response.getData();
    List<EOrders> eOrders = localListByDateResponse.getEOrders();
    for(EOrders eOrder: eOrders) {
    	System.out.println(eOrder);
    }
  } else {
    //调用失败，通过getCode和getMsg获取错误码和错误描述
    System.out.println(response.getCode());
    System.out.println(response.getMsg());
  }
} catch (MtSdkException e) {
  e.printStackTrace();
}
```
