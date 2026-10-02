package com.goodskill.service.impl;
 import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goodskill.entity.mysql.UserRole;
import com.goodskill.mapper.UserRoleMapper;
import com.goodskill.service.UserRoleService;
import org.springframework.stereotype.Service;
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>implements UserRoleService{


}