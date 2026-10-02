package com.goodskill.service.impl;
 import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goodskill.entity.mysql.RolePermission;
import com.goodskill.mapper.RolePermissionMapper;
import com.goodskill.service.RolePermissionService;
import org.springframework.stereotype.Service;
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>implements RolePermissionService{


}