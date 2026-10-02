package com.goodskill.dto.ChatRequestDTO;
 import java.util.List;
public class Message {

 private  String role;

 private  String content;


public void setContent(String content){
    this.content = content;
}


public void setRole(String role){
    this.role = role;
}


public String getContent(){
    return content;
}


public String getRole(){
    return role;
}


}