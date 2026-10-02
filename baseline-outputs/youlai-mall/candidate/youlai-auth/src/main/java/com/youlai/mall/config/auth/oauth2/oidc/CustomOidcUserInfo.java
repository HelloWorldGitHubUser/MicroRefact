package com.youlai.mall.config.auth.oauth2.oidc;
 import cn.hutool.core.lang.Assert;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
public class CustomOidcUserInfo extends OidcUserInfo{

 private  long serialVersionUID;

 private  Map<String,Object> claims;

 private  Map<String,Object> claims;

public CustomOidcUserInfo(Map<String, Object> claims) {
    super(claims);
    Assert.notEmpty(claims, "claims cannot be empty");
    this.claims = Collections.unmodifiableMap(new LinkedHashMap(claims));
}
public Builder customBuilder(){
    return new Builder();
}


public Builder address(String address){
    return this.claim("address", address);
}


public Builder profile(String profile){
    return this.claim("profile", profile);
}


public Builder description(String description){
    return this.claim("description", description);
}


public Map<String,Object> getClaims(){
    return this.claims;
}


public Builder phoneNumber(String phoneNumber){
    return this.claim("phone_number", phoneNumber);
}


public CustomOidcUserInfo build(){
    return new CustomOidcUserInfo(this.claims);
}


public int hashCode(){
    return this.getClaims().hashCode();
}


public boolean equals(Object obj){
    if (this == obj) {
        return true;
    } else if (obj != null && this.getClass() == obj.getClass()) {
        CustomOidcUserInfo that = (CustomOidcUserInfo) obj;
        return this.getClaims().equals(that.getClaims());
    } else {
        return false;
    }
}


public Builder claims(Consumer<Map<String,Object>> claimsConsumer){
    claimsConsumer.accept(this.claims);
    return this;
}


public Builder nickname(String nickname){
    return this.claim("nickname", nickname);
}


public Builder claim(String name,Object value){
    this.claims.put(name, value);
    return this;
}


public Builder email(String email){
    return this.claim("email", email);
}


public Builder username(String username){
    return this.claim("username", username);
}


public Builder status(Integer status){
    return this.claim("status", status);
}


}