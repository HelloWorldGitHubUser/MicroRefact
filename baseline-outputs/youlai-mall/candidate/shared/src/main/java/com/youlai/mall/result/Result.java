package com.youlai.mall.result;
 import lombok.Data;
import java.io.Serializable;
@Data
public class Result implements Serializable{

 private  String code;

 private  T data;

 private  String msg;


public Result<T> result(String code,String msg,T data){
    Result<T> result = new Result<>();
    result.setCode(code);
    result.setData(data);
    result.setMsg(msg);
    return result;
}


public Result<T> success(T data){
    Result<T> result = new Result<>();
    result.setCode(ResultCode.SUCCESS.getCode());
    result.setMsg(ResultCode.SUCCESS.getMsg());
    result.setData(data);
    return result;
}


public Result<T> failed(IResultCode resultCode,String msg){
    return result(resultCode.getCode(), msg, null);
}


public Result<T> judge(boolean status){
    if (status) {
        return success();
    } else {
        return failed();
    }
}


public boolean isSuccess(Result<?> result){
    return result != null && ResultCode.SUCCESS.getCode().equals(result.getCode());
}


}