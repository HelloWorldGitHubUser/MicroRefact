package com.central.model;
 import com.central.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable{

 private  T datas;

 private  Integer resp_code;

 private  String resp_msg;


public Result<T> succeed(T model){
    return of(model, CodeEnum.SUCCESS.getCode(), "");
}


public Result<T> of(T datas,Integer code,String msg){
    return new Result<>(datas, code, msg);
}


public Result<T> failed(T model,String msg){
    return of(model, CodeEnum.ERROR.getCode(), msg);
}


}