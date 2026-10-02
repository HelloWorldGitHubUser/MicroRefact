package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface MallUserMapper {


public MallUser selectByPrimaryKey(Long userId)
;

public int insertSelective(MallUser record)
;

public int getTotalMallUsers(PageQueryUtil pageUtil)
;

public int updateByPrimaryKeySelective(MallUser record)
;

public int updateByPrimaryKey(MallUser record)
;

public int insert(MallUser record)
;

public MallUser selectByLoginName(String loginName)
;

public int deleteByPrimaryKey(Long userId)
;

public int lockUserBatch(Long[] ids,int lockStatus)
;

public List<MallUser> findMallUserList(PageQueryUtil pageUtil)
;

public MallUser selectByLoginNameAndPasswd(String loginName,String password)
;

}