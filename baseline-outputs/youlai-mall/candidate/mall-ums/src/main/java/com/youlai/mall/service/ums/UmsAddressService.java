package com.youlai.mall.service.ums;
 import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.ums.dto.MemberAddressDTO;
import com.youlai.mall.model.ums.entity.UmsAddress;
import com.youlai.mall.model.ums.form.AddressForm;
import java.util.List;
public interface UmsAddressService extends IService<UmsAddress>{


public boolean updateAddress(AddressForm addressForm)
;

public boolean addAddress(AddressForm addressForm)
;

public List<MemberAddressDTO> listCurrentMemberAddresses()
;

}