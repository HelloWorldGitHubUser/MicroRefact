package com.central.log.model;
 import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Setter
@Getter
public class Audit {

 private  LocalDateTime timestamp;

 private  String applicationName;

 private  String className;

 private  String methodName;

 private  String userId;

 private  String userName;

 private  String clientId;

 private  String operation;


}