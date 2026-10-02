package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.MallUserToken;
public interface NewBeeMallUserTokenMapper {


public MallUserToken selectByPrimaryKey(Long userId)
;

public int insertSelective(MallUserToken record)
;

public int updateByPrimaryKeySelective(MallUserToken record)
;

public int updateByPrimaryKey(MallUserToken record)
;

public int insert(MallUserToken record)
;

public MallUserToken selectByToken(String token)
;

public int deleteByPrimaryKey(Long userId)
;

}