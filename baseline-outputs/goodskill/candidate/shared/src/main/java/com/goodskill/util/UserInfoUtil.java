package com.goodskill.util;
 public class UserInfoUtil {


public String getUserId(){
    // 使用HeaderUtil的方法从请求头中获取userId，这里省略了具体的实现细节
    String userId = HeaderUtil.getUserId();
    return userId == null ? "" : userId;
}


}