package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.AdminUserToken;
public interface NewBeeAdminUserTokenMapper {


public AdminUserToken selectByPrimaryKey(Long userId)
;

public int insertSelective(AdminUserToken record)
;

public int updateByPrimaryKeySelective(AdminUserToken record)
;

public int updateByPrimaryKey(AdminUserToken record)
;

public int insert(AdminUserToken record)
;

public AdminUserToken selectByToken(String token)
;

public int deleteByPrimaryKey(Long userId)
;

}