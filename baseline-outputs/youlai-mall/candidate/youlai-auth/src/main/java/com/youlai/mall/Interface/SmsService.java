package com.youlai.mall.Interface;
public interface SmsService {

   public boolean sendSms(String mobile,String templateCode,String templateParam);
}