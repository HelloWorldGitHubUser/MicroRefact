package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.AdminUser;
import org.apache.ibatis.annotations.Param;
public interface AdminUserMapper {


public AdminUser selectByPrimaryKey(Long adminUserId)
;

public int insertSelective(AdminUser record)
;

public int updateByPrimaryKeySelective(AdminUser record)
;

public int updateByPrimaryKey(AdminUser record)
;

public int insert(AdminUser record)
;

public AdminUser login(String userName,String password)
;

}