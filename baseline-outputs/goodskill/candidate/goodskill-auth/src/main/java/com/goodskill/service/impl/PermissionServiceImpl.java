package com.goodskill.service.impl;
 import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goodskill.entity.mysql.Permission;
import com.goodskill.mapper.PermissionMapper;
import com.goodskill.service.PermissionService;
import org.springframework.stereotype.Service;
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>implements PermissionService{


}