package com.central.security;
 import com.alibaba.ttl.TransmittableThreadLocal;
public class LoginUserContextHolder {

 private  ThreadLocal<LoginAppUser> CONTEXT;


public LoginAppUser getUser(){
    return CONTEXT.get();
}


public void clear(){
    CONTEXT.remove();
}


public void setUser(LoginAppUser user){
    CONTEXT.set(user);
}


}