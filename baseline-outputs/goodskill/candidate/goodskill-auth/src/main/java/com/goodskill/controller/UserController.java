package com.goodskill.controller;
 import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.goodskill.entity.mysql.User;
import com.goodskill.vo.UserInfoVO;
import com.goodskill.service.UserService;
import com.goodskill.dto.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation;
import java.util.List;
import com.goodskill.DTO.Result;
@RestController
@Tag(name = "用户管理")
@RequestMapping("/user")
public class UserController {

@Resource
 private  UserService userService;

@Resource
 private  StpInterface stpInterface;


@GetMapping("/info")
@Operation(summary = "获取用户信息")
public Result<?> getUser(){
    Object loginId = StpUtil.getLoginId();
    StpUtil.hasPermission("/test");
    StpUtil.hasRole("test");
    User info = userService.getUserInfoById(loginId.toString());
    List<String> permissionList = StpUtil.getPermissionList();
    List<String> roleList = StpUtil.getRoleList();
    UserInfoVO userInfoVO = new UserInfoVO();
    userInfoVO.setUser(info);
    userInfoVO.setPermissions(permissionList);
    userInfoVO.setRoles(roleList);
    return Result.ok(userInfoVO);
}


@GetMapping("/listUserPermission")
@Operation(summary = "获取用户权限")
public List<String> listUserPermission(String loginId,String loginType){
    return stpInterface.getPermissionList(loginId, loginType);
}


@GetMapping("/listUserRole")
@Operation(summary = "获取用户角色")
public List<String> listUserRole(String loginId,String loginType){
    return stpInterface.getRoleList(loginId, loginType);
}


@PostMapping("/role/add")
@Operation(summary = "为用户增加角色")
public Result<String> addRole(int userId,int roleId){
    userService.addRole(userId, roleId);
    SaSession sessionByLoginId = StpUtil.getSessionByLoginId(userId);
    sessionByLoginId.delete("Role_List");
    return Result.ok();
}


}