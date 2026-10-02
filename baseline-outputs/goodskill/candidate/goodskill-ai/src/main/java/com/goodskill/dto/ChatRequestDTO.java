package com.goodskill.dto;
 import java.util.List;
public class ChatRequestDTO {

 private  String model;

 private  List<Message> messages;

 private  boolean stream;

 private  String role;

 private  String content;


public String getModel(){
    return model;
}


public void setContent(String content){
    this.content = content;
}


public void setStream(boolean stream){
    this.stream = stream;
}


public void setRole(String role){
    this.role = role;
}


public String getContent(){
    return content;
}


public void setModel(String model){
    this.model = model;
}


public boolean isStream(){
    return stream;
}


public String getRole(){
    return role;
}


public void setMessages(List<Message> messages){
    this.messages = messages;
}


public List<Message> getMessages(){
    return messages;
}


}