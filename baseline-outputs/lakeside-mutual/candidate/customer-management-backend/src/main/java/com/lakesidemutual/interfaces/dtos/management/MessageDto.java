package com.lakesidemutual.interfaces.dtos.management;
 import java.util.Date;
import jakarta.validation.constraints.NotEmpty;
public class MessageDto {

 private  String id;

 private  Date date;

@NotEmpty
 private  String customerId;

@NotEmpty
 private  String username;

@NotEmpty
 private  String content;

 private  boolean sentByOperator;

public MessageDto() {
}public MessageDto(String id, Date date, String customerId, String username, String content, boolean sentByOperator) {
    this.id = id;
    this.date = date;
    this.customerId = customerId;
    this.username = username;
    this.content = content;
    this.sentByOperator = sentByOperator;
}
public void setContent(String content){
    this.content = content;
}


public void setUsername(String username){
    this.username = username;
}


public void setSentByOperator(boolean sentByOperator){
    this.sentByOperator = sentByOperator;
}


public String getContent(){
    return content;
}


public void setId(String id){
    this.id = id;
}


public void setDate(Date date){
    this.date = date;
}


public String getId(){
    return id;
}


public Date getDate(){
    return date;
}


public void setCustomerId(String customerId){
    this.customerId = customerId;
}


public boolean isSentByOperator(){
    return sentByOperator;
}


public String getCustomerId(){
    return customerId;
}


public String getUsername(){
    return username;
}


}