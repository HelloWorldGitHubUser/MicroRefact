package com.youlai.mall.config.oms;
 import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "wx.pay")
public class WxPayProperties {

 private  String mchId;

 private  String mchKey;

 private  String subAppId;

 private  String subMchId;

 private  String keyPath;

 private  String privateKeyPath;

 private  String privateCertPath;

 private  String apiV3Key;

 private  String certSerialNo;

 private  Boolean sandboxEnabled;

 private  String payNotifyUrl;

 private  String refundNotifyUrl;


}