package com.goodskill.service.impl;
 import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goodskill.entity.mysql.Role;
import com.goodskill.mapper.RoleMapper;
import com.goodskill.service.RoleService;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>implements RoleService{


}