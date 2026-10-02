package com.goodskill.service;
 import com.goodskill.bo.UserBO;
public interface UserAuthAccountService {


public Boolean ifThirdAccountExists(String account,String sourceType)
;

public UserBO findByThirdAccount(String account,String sourceType)
;

}