package com.lakesidemutual.interfaces.dtos.policy.risk;
 import java.util.Date;
public class RiskFactorRequestDto {

 private  Date birthday;

 private  String postalCode;

public RiskFactorRequestDto() {
}public RiskFactorRequestDto(Date birthday, String postalCode) {
    this.setBirthday(birthday);
    this.setPostalCode(postalCode);
}
public Date getBirthday(){
    return birthday;
}


public String getPostalCode(){
    return postalCode;
}


public void setPostalCode(String postalCode){
    this.postalCode = postalCode;
}


public void setBirthday(Date birthday){
    this.birthday = birthday;
}


}