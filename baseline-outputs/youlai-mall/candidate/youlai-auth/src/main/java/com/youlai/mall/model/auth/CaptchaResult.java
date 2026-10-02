package com.youlai.mall.model.auth;
 import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class CaptchaResult {

 private  String captchaId;

 private  String captchaBase64;


}