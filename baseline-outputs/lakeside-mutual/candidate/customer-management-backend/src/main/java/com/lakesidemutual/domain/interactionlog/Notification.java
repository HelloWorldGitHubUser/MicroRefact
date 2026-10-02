package com.lakesidemutual.domain.interactionlog;
 import org.microserviceapipatterns.domaindrivendesign.ValueObject;
public class Notification implements ValueObject{

 private  String customerId;

 private  String username;

 private  int count;

public Notification(String customerId, String username, int count) {
    this.customerId = customerId;
    this.username = username;
    this.count = count;
}
public int getCount(){
    return count;
}


public String getCustomerId(){
    return customerId;
}


public String getUsername(){
    return username;
}


}