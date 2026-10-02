package com.youlai.mall.controller;
 import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.mall.result.PageResult;
import com.youlai.mall.result.Result;
import com.youlai.mall.web.annotation.PreventDuplicateResubmit;
import com.youlai.mall.model.system.dto.UserAuthInfo;
import com.youlai.mall.listener.UserImportListener;
import com.youlai.mall.model.system.entity.SysUser;
import com.youlai.mall.model.system.form.UserForm;
import com.youlai.mall.model.system.form.UserRegisterForm;
import com.youlai.mall.model.system.query.UserPageQuery;
import com.youlai.mall.model.system.vo;
import com.youlai.mall.service.system.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
@Tag(name = "01.用户接口")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class SysUserController {

 private  SysUserService userService;


@Operation(summary = "用户导入模板下载")
@GetMapping("/template")
public void downloadTemplate(HttpServletResponse response) throws IOException{
    String fileName = "用户导入模板.xlsx";
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
    String fileClassPath = "excel-templates" + File.separator + fileName;
    InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);
    ServletOutputStream outputStream = response.getOutputStream();
    ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build();
    excelWriter.finish();
}


@Operation(summary = "导入用户")
@PostMapping("/import")
public Result importUsers(Long deptId,MultipartFile file) throws IOException{
    UserImportListener listener = new UserImportListener(deptId);
    EasyExcel.read(file.getInputStream(), UserImportVO.class, listener).sheet().doRead();
    String msg = listener.getMsg();
    return Result.success(msg);
}


@Operation(summary = "导出用户")
@GetMapping("/export")
public void exportUsers(UserPageQuery queryParams,HttpServletResponse response) throws IOException{
    String fileName = "用户列表.xlsx";
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
    List<UserExportVO> exportUserList = userService.listExportUsers(queryParams);
    EasyExcel.write(response.getOutputStream(), UserExportVO.class).sheet("用户列表").doWrite(exportUserList);
}


@Operation(summary = "修改用户密码")
@PatchMapping(value = "/{userId}/password")
@PreAuthorize("@ss.hasPerm('sys:user:reset_pwd')")
public Result updatePassword(Long userId,String password){
    boolean result = userService.updatePassword(userId, password);
    return Result.judge(result);
}


@Operation(summary = "用户分页列表")
@GetMapping("/page")
public PageResult<UserPageVO> getUserPage(UserPageQuery queryParams){
    IPage<UserPageVO> result = userService.getUserPage(queryParams);
    return PageResult.success(result);
}


@Operation(summary = "修改用户")
@PutMapping(value = "/{userId}")
@PreAuthorize("@ss.hasPerm('sys:user:edit')")
public Result updateUser(Long userId,UserForm userForm){
    boolean result = userService.updateUser(userId, userForm);
    return Result.judge(result);
}


@Operation(summary = "删除用户")
@DeleteMapping("/{ids}")
@PreAuthorize("@ss.hasPerm('sys:user:delete')")
public Result deleteUsers(String ids){
    boolean result = userService.deleteUsers(ids);
    return Result.judge(result);
}


@Operation(summary = "获取用户个人中心信息")
@GetMapping("/profile")
public Result getUserProfile(){
    UserProfileVO userProfile = userService.getUserProfile();
    return Result.success(userProfile);
}


@Operation(summary = "发送注册短信验证码")
@PostMapping("/register/sms_code")
public Result sendRegistrationSmsCode(String mobile){
    boolean result = userService.sendRegistrationSmsCode(mobile);
    return Result.judge(result);
}


@Operation(summary = "获取登录用户信息")
@GetMapping("/me")
public Result<UserInfoVO> getCurrentUserInfo(){
    UserInfoVO userInfoVO = userService.getCurrentUserInfo();
    return Result.success(userInfoVO);
}


@Operation(summary = "获取用户认证信息", hidden = true)
@GetMapping("/{username}/authInfo")
public Result<UserAuthInfo> getUserAuthInfo(String username){
    UserAuthInfo userAuthInfo = userService.getUserAuthInfo(username);
    return Result.success(userAuthInfo);
}


@Operation(summary = "注销登出")
@DeleteMapping("/logout")
public Result logout(){
    boolean result = userService.logout();
    return Result.judge(result);
}


@Operation(summary = "用户表单数据")
@GetMapping("/{userId}/form")
public Result<UserForm> getUserForm(Long userId){
    UserForm formData = userService.getUserFormData(userId);
    return Result.success(formData);
}


@Operation(summary = "注册用户")
@PostMapping("/register")
public Result registerUser(UserRegisterForm userRegisterForm){
    boolean result = userService.registerUser(userRegisterForm);
    return Result.judge(result);
}


@Operation(summary = "修改用户状态")
@PatchMapping(value = "/{userId}/status")
public Result updateUserStatus(Long userId,Integer status){
    boolean result = userService.update(new LambdaUpdateWrapper<SysUser>().eq(SysUser::getId, userId).set(SysUser::getStatus, status));
    return Result.judge(result);
}


@Operation(summary = "新增用户")
@PostMapping
@PreAuthorize("@ss.hasPerm('sys:user:add')")
@PreventDuplicateResubmit
public Result saveUser(UserForm userForm){
    boolean result = userService.saveUser(userForm);
    return Result.judge(result);
}


}