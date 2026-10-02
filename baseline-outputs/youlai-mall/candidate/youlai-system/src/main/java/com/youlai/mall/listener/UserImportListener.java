package com.youlai.mall.listener;
 import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.mall.base.IBaseEnum;
import com.youlai.mall.constant.SystemConstants;
import com.youlai.mall.enums.GenderEnum;
import com.youlai.mall.enums.StatusEnum;
import com.youlai.mall.converter.UserConverter;
import com.youlai.mall.model.system.entity.SysRole;
import com.youlai.mall.model.system.entity.SysUser;
import com.youlai.mall.model.system.entity.SysUserRole;
import com.youlai.mall.model.system.vo.UserImportVO;
import com.youlai.mall.service.system.SysRoleService;
import com.youlai.mall.service.system.SysUserRoleService;
import com.youlai.mall.service.system.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class UserImportListener extends MyAnalysisEventListener<UserImportVO>{

 private  int validCount;

 private  int invalidCount;

 private StringBuilder msg;

 private  Long deptId;

 private  SysUserService userService;

 private  PasswordEncoder passwordEncoder;

 private  UserConverter userConverter;

 private  SysRoleService roleService;

 private  SysUserRoleService userRoleService;

public UserImportListener(Long deptId) {
    this.deptId = deptId;
    this.userService = SpringUtil.getBean(SysUserService.class);
    this.passwordEncoder = SpringUtil.getBean(PasswordEncoder.class);
    this.roleService = SpringUtil.getBean(SysRoleService.class);
    this.userRoleService = SpringUtil.getBean(SysUserRoleService.class);
    this.userConverter = SpringUtil.getBean(UserConverter.class);
}
@Override
public String getMsg(){
    // 总结信息
    String summaryMsg = StrUtil.format("导入用户结束：成功{}条，失败{}条；<br/>{}", validCount, invalidCount, msg);
    return summaryMsg;
}


@Override
public void invoke(UserImportVO userImportVO,AnalysisContext analysisContext){
    log.info("解析到一条用户数据:{}", JSONUtil.toJsonStr(userImportVO));
    // 校验数据
    StringBuilder validationMsg = new StringBuilder();
    String username = userImportVO.getUsername();
    if (StrUtil.isBlank(username)) {
        validationMsg.append("用户名为空；");
    } else {
        long count = userService.count(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (count > 0) {
            validationMsg.append("用户名已存在；");
        }
    }
    String nickname = userImportVO.getNickname();
    if (StrUtil.isBlank(nickname)) {
        validationMsg.append("用户昵称为空；");
    }
    String mobile = userImportVO.getMobile();
    if (StrUtil.isBlank(mobile)) {
        validationMsg.append("手机号码为空；");
    } else {
        if (!Validator.isMobile(mobile)) {
            validationMsg.append("手机号码不正确；");
        }
    }
    if (validationMsg.length() == 0) {
        // 校验通过，持久化至数据库
        SysUser entity = userConverter.importVo2Entity(userImportVO);
        // 部门
        entity.setDeptId(deptId);
        // 默认密码
        entity.setPassword(passwordEncoder.encode(SystemConstants.DEFAULT_PASSWORD));
        // 性别翻译
        String genderLabel = userImportVO.getGender();
        if (StrUtil.isNotBlank(genderLabel)) {
            Integer genderValue = (Integer) IBaseEnum.getValueByLabel(genderLabel, GenderEnum.class);
            entity.setGender(genderValue);
        }
        // 角色解析
        String roleCodes = userImportVO.getRoleCodes();
        List<Long> roleIds = null;
        if (StrUtil.isNotBlank(roleCodes)) {
            roleIds = roleService.list(new LambdaQueryWrapper<SysRole>().in(SysRole::getCode, roleCodes.split(",")).eq(SysRole::getStatus, StatusEnum.ENABLE.getValue()).select(SysRole::getId)).stream().map(role -> role.getId()).collect(Collectors.toList());
        }
        boolean saveResult = userService.save(entity);
        if (saveResult) {
            validCount++;
            // 保存用户角色关联
            if (CollectionUtil.isNotEmpty(roleIds)) {
                List<SysUserRole> userRoles = roleIds.stream().map(roleId -> new SysUserRole(entity.getId(), roleId)).collect(Collectors.toList());
                userRoleService.saveBatch(userRoles);
            }
        } else {
            invalidCount++;
            msg.append("第" + (validCount + invalidCount) + "行数据保存失败；<br/>");
        }
    } else {
        invalidCount++;
        msg.append("第" + (validCount + invalidCount) + "行数据校验失败：").append(validationMsg + "<br/>");
    }
}


@Override
public void doAfterAllAnalysed(AnalysisContext analysisContext){
}


}