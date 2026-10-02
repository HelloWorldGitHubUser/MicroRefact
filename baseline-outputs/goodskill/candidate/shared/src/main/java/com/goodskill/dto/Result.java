package com.goodskill.dto;
 import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
@Data
public class Result implements Serializable{

@Serial
 private  long serialVersionUID;

 public  int SUCCESS;

 public  int FAIL;

 private  int code;

 private  String msg;

 private  T data;


public Result<T> fail(int code,String msg){
    return restResult(null, code, msg);
}


public Result<T> restResult(T data,int code,String msg){
    Result<T> apiResult = new Result<>();
    apiResult.setCode(code);
    apiResult.setData(data);
    apiResult.setMsg(msg);
    return apiResult;
}


public Result<T> ok(T data,String msg){
    return restResult(data, SUCCESS, msg);
}


}