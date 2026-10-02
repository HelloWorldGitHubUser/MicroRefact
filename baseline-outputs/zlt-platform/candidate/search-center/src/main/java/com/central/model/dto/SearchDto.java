package com.central.model.dto;
 import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
public class SearchDto implements Serializable{

 private  long serialVersionUID;

 private  String queryStr;

 private  Integer page;

 private  Integer limit;

 private  String sortCol;

 private  String sortOrder;

 private  Boolean isHighlighter;

 private  String routing;


}