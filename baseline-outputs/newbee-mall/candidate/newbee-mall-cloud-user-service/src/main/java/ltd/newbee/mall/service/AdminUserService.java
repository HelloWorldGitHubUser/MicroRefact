package ltd.newbee.mall.service;
 import ltd.newbee.mall.entity.AdminUser;
public interface AdminUserService {


public Boolean logout(Long adminUserId)
;

public Boolean updatePassword(Long loginUserId,String originalPassword,String newPassword)
;

public AdminUser getUserDetailById(Long loginUserId)
;

public String login(String userName,String password)
;

public Boolean updateName(Long loginUserId,String loginUserName,String nickName)
;

}