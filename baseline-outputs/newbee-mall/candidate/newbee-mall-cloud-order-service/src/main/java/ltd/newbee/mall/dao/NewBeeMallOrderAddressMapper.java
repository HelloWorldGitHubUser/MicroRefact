package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.NewBeeMallOrderAddress;
public interface NewBeeMallOrderAddressMapper {


public NewBeeMallOrderAddress selectByPrimaryKey(Long orderId)
;

public int insertSelective(NewBeeMallOrderAddress record)
;

public int updateByPrimaryKeySelective(NewBeeMallOrderAddress record)
;

public int updateByPrimaryKey(NewBeeMallOrderAddress record)
;

public int insert(NewBeeMallOrderAddress record)
;

public int deleteByPrimaryKey(Long orderId)
;

}