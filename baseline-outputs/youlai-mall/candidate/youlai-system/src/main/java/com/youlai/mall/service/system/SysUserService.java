package com.youlai.mall.service.system;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.system.dto.UserAuthInfo;
import com.youlai.mall.model.system.entity.SysUser;
import com.youlai.mall.model.system.form.UserForm;
import com.youlai.mall.model.system.form.UserRegisterForm;
import com.youlai.mall.model.system.query.UserPageQuery;
import com.youlai.mall.model.system.vo.UserExportVO;
import com.youlai.mall.model.system.vo.UserInfoVO;
import com.youlai.mall.model.system.vo.UserPageVO;
import com.youlai.mall.model.system.vo.UserProfileVO;
import java.util.List;
public interface SysUserService extends IService<SysUser>{


public boolean updatePassword(Long userId,String password)
;

public IPage<UserPageVO> getUserPage(UserPageQuery queryParams)
;

public boolean updateUser(Long userId,UserForm userForm)
;

public boolean deleteUsers(String idsStr)
;

public UserForm getUserFormData(Long userId)
;

public UserProfileVO getUserProfile()
;

public boolean sendRegistrationSmsCode(String mobile)
;

public UserInfoVO getCurrentUserInfo()
;

public UserAuthInfo getUserAuthInfo(String username)
;

public boolean logout()
;

public List<UserExportVO> listExportUsers(UserPageQuery queryParams)
;

public boolean registerUser(UserRegisterForm userRegisterForm)
;

public boolean saveUser(UserForm userForm)
;

}