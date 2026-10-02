package com.youlai.mall.base;
 import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.io.Serializable;
@Data
@Schema
public class BasePageQuery implements Serializable{

@Schema(description = "页码", example = "1")
 private  int pageNum;

@Schema(description = "每页记录数", example = "10")
 private  int pageSize;


}