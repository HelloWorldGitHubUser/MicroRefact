package io.gulimall.exception;
 public class RRException extends RuntimeException{

 private  long serialVersionUID;

 private  String msg;

 private  int code;

public RRException(String msg) {
    super(msg);
    this.msg = msg;
}public RRException(String msg, Throwable e) {
    super(msg, e);
    this.msg = msg;
}public RRException(String msg, int code) {
    super(msg);
    this.msg = msg;
    this.code = code;
}public RRException(String msg, int code, Throwable e) {
    super(msg, e);
    this.msg = msg;
    this.code = code;
}
public String getMsg(){
    return msg;
}


public void setCode(int code){
    this.code = code;
}


public void setMsg(String msg){
    this.msg = msg;
}


public int getCode(){
    return code;
}


}