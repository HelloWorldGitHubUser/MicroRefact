package com.goodskill.service.impl;
 import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goodskill.entity.mysql.User;
import com.goodskill.entity.mysql.UserAuthAccount;
import com.goodskill.mapper.UserAuthAccountMapper;
import com.goodskill.bo.UserBO;
import com.goodskill.service.UserAuthAccountService;
import com.goodskill.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Service
public class UserAuthAccountServiceImpl extends ServiceImpl<UserAuthAccountMapper, UserAuthAccount>implements UserAuthAccountService{

@Resource
 private  UserService userService;

@Resource
 private  UserAuthAccountMapper baseMapper;


@Override
public Boolean ifThirdAccountExists(String account,String sourceType){
    return baseMapper.selectCount(new LambdaQueryWrapper<UserAuthAccount>().eq(UserAuthAccount::getThirdAccountName, account).eq(UserAuthAccount::getSourceType, sourceType)) == 1;
}


@Override
public UserBO findByThirdAccount(String account,String sourceType){
    UserBO userBo = new UserBO();
    UserAuthAccount userAuthAccount = baseMapper.selectOne(new LambdaQueryWrapper<UserAuthAccount>().eq(UserAuthAccount::getThirdAccountName, account).eq(UserAuthAccount::getSourceType, sourceType));
    User user = userService.getById(userAuthAccount.getUserId());
    BeanUtils.copyProperties(user, userBo);
    userBo.setThirdAccountId(userAuthAccount.getThirdAccountId());
    userBo.setSourceType(userAuthAccount.getSourceType());
    userBo.setThirdAccountName(userAuthAccount.getThirdAccountName());
    return userBo;
}


}