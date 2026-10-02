package ltd.newbee.mall.service;
 import ltd.newbee.mall.api.mall.vo.NewBeeMallUserAddressVO;
import ltd.newbee.mall.entity.MallUserAddress;
import java.util.List;
public interface NewBeeMallUserAddressService {


public Boolean saveUserAddress(MallUserAddress mallUserAddress)
;

public Boolean deleteById(Long addressId)
;

public MallUserAddress getMallUserAddressById(Long addressId)
;

public MallUserAddress getMyDefaultAddressByUserId(Long userId)
;

public List<NewBeeMallUserAddressVO> getMyAddresses(Long userId)
;

public Boolean updateMallUserAddress(MallUserAddress mallUserAddress)
;

}