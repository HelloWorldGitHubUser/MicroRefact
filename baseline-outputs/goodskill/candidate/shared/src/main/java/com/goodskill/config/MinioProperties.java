package com.goodskill.config;
 import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

 private  String bucketName;

 private  String accessKey;

 private  String secretKey;

 private  String endpoint;


public String getSecretKey(){
    return secretKey;
}


public void setSecretKey(String secretKey){
    this.secretKey = secretKey;
}


public void setAccessKey(String accessKey){
    this.accessKey = accessKey;
}


public String getAccessKey(){
    return accessKey;
}


public String getEndpoint(){
    return endpoint;
}


public void setBucketName(String bucketName){
    this.bucketName = bucketName;
}


public void setEndpoint(String endpoint){
    this.endpoint = endpoint;
}


public String getBucketName(){
    return bucketName;
}


}