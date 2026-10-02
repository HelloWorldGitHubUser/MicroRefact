package com.passjava.utils;
 import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
public class R extends HashMap<String, Object>{

 private  long serialVersionUID;

public R() {
    put("code", 0);
    put("msg", "success");
}
public R error(int code,String msg){
    R r = new R();
    r.put("code", code);
    r.put("msg", msg);
    return r;
}


public R ok(){
    return new R();
}


public R put(String key,Object value){
    super.put(key, value);
    return this;
}


}