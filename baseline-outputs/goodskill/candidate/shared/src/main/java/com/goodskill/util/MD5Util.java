package com.goodskill.util;
 import org.springframework.util.DigestUtils;
public class MD5Util {

 private  String SLAT;

private MD5Util() {
}
public String getMD5(long seckillId){
    String base = seckillId + "/" + SLAT;
    return DigestUtils.md5DigestAsHex(base.getBytes());
}


}