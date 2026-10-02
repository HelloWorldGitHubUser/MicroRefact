package com.central.model.dto;
 import lombok.Data;
import java.io.Serializable;
@Data
public class IndexDto implements Serializable{

 private  long serialVersionUID;

 private  String indexName;

 private  Integer numberOfShards;

 private  Integer numberOfReplicas;

 private  String type;

 private  String mappingsSource;


}