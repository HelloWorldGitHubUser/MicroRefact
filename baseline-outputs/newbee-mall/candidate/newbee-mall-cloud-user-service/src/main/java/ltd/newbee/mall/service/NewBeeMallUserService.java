package ltd.newbee.mall.service;
 import ltd.newbee.mall.api.mall.param.MallUserUpdateParam;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
public interface NewBeeMallUserService {


public Boolean logout(Long userId)
;

public Boolean updateUserInfo(MallUserUpdateParam mallUser,Long userId)
;

public PageResult getNewBeeMallUsersPage(PageQueryUtil pageUtil)
;

public Boolean lockUsers(Long[] ids,int lockStatus)
;

public String login(String loginName,String passwordMD5)
;

public String register(String loginName,String password)
;

}