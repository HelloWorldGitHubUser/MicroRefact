package com.goodskill.dto;
 import lombok.Data;
import java.io.Serializable;
@Data
public class ChatMessageDto implements Serializable{

 private  String message;

 private  String token;


}