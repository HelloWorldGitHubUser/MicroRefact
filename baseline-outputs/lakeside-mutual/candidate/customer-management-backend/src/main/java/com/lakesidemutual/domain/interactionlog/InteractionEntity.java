package com.lakesidemutual.domain.interactionlog;
 import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "interactions")
public class InteractionEntity {

@Id
 private  String id;

 private  Date date;

 private  String content;

 private  boolean sentByOperator;

public InteractionEntity() {
}public InteractionEntity(String id, Date date, String content, boolean sentByOperator) {
    this.id = id;
    this.date = date;
    this.content = content;
    this.sentByOperator = sentByOperator;
}
public void setContent(String content){
    this.content = content;
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


public boolean isSentByOperator(){
    return sentByOperator;
}


}