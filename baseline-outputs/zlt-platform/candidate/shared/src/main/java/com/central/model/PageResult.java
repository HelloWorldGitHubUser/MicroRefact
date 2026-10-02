package com.central.model;
 import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult implements Serializable{

 private  long serialVersionUID;

 private  Long count;

 private  int code;

 private  List<T> data;


}