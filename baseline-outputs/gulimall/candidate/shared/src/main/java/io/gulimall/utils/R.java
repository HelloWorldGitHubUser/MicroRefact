package io.gulimall.utils;
 import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
public class R extends HashMap<String, Object>{

 private  long serialVersionUID;

public R() {
    put("code", 0);
    put("msg", "success");
}
public R setData(Object data){
    put("data", data);
    return this;
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


public Integer getCode(){
    return (Integer) this.get("code");
}


public R put(String key,Object value){
    super.put(key, value);
    return this;
}


public T getData(String key,TypeReference<T> tTypeReference){
    Object data = this.get(key);
    String toJSONString = JSON.toJSONString(data);
    T t = JSON.parseObject(toJSONString, tTypeReference);
    return t;
}


}