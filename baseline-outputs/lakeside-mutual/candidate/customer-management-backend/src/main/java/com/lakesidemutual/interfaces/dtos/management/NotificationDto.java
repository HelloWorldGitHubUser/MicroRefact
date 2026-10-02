package com.lakesidemutual.interfaces.dtos.management;
 public class NotificationDto {

 private  String customerId;

 private  String username;

 private  int count;

public NotificationDto() {
}public NotificationDto(String customerId, String username, int count) {
    this.customerId = customerId;
    this.username = username;
    this.count = count;
}
public void setUsername(String username){
    this.username = username;
}


public void setCustomerId(String customerId){
    this.customerId = customerId;
}


public int getCount(){
    return count;
}


public String getCustomerId(){
    return customerId;
}


public void setCount(int count){
    this.count = count;
}


public String getUsername(){
    return username;
}


}