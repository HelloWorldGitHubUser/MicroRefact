package ltd.newbee.mall.util;
 import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
public class Result implements Serializable{

 private  long serialVersionUID;

@ApiModelProperty("返回码")
 private  int resultCode;

@ApiModelProperty("返回信息")
 private  String message;

@ApiModelProperty("返回数据")
 private  T data;

public Result() {
}public Result(int resultCode, String message) {
    this.resultCode = resultCode;
    this.message = message;
}
public int getResultCode(){
    return resultCode;
}


public void setData(T data){
    this.data = data;
}


public String getMessage(){
    return message;
}


@Override
public String toString(){
    return "Result{" + "resultCode=" + resultCode + ", message='" + message + '\'' + ", data=" + data + '}';
}


public void setResultCode(int resultCode){
    this.resultCode = resultCode;
}


public void setMessage(String message){
    this.message = message;
}


public T getData(){
    return data;
}


}