package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.MallUserAddress;
import java.util.List;
public interface MallUserAddressMapper {


public MallUserAddress selectByPrimaryKey(Long addressId)
;

public int insertSelective(MallUserAddress record)
;

public List<MallUserAddress> findMyAddressList(Long userId)
;

public int updateByPrimaryKeySelective(MallUserAddress record)
;

public int updateByPrimaryKey(MallUserAddress record)
;

public int insert(MallUserAddress record)
;

public int deleteByPrimaryKey(Long addressId)
;

public MallUserAddress getMyDefaultAddress(Long userId)
;

}