package com.youlai.mall.service.ums.impl;
 import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlai.mall.constant.GlobalConstants;
import com.youlai.mall.security.util.SecurityUtils;
import com.youlai.mall.model.ums.dto.MemberAddressDTO;
import com.youlai.mall.mapper.UmsAddressMapper;
import com.youlai.mall.model.ums.entity.UmsAddress;
import com.youlai.mall.model.ums.form.AddressForm;
import com.youlai.mall.service.ums.UmsAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UmsAddressServiceImpl extends ServiceImpl<UmsAddressMapper, UmsAddress>implements UmsAddressService{


@Override
public boolean updateAddress(AddressForm addressForm){
    Long memberId = SecurityUtils.getMemberId();
    UmsAddress umsAddress = new UmsAddress();
    BeanUtil.copyProperties(addressForm, umsAddress);
    boolean result = this.updateById(umsAddress);
    if (result) {
        // 修改其他默认地址为非默认
        if (GlobalConstants.STATUS_YES.equals(addressForm.getDefaulted())) {
            this.update(new LambdaUpdateWrapper<UmsAddress>().eq(UmsAddress::getMemberId, memberId).eq(UmsAddress::getDefaulted, 1).ne(UmsAddress::getId, umsAddress.getId()).set(UmsAddress::getDefaulted, 0));
        }
    }
    return result;
}


@Override
@Transactional
public boolean addAddress(AddressForm addressForm){
    Long memberId = SecurityUtils.getMemberId();
    UmsAddress umsAddress = new UmsAddress();
    BeanUtil.copyProperties(addressForm, umsAddress);
    umsAddress.setMemberId(memberId);
    boolean result = this.save(umsAddress);
    if (result) {
        // 修改其他默认地址为非默认
        if (GlobalConstants.STATUS_YES.equals(addressForm.getDefaulted())) {
            this.update(new LambdaUpdateWrapper<UmsAddress>().eq(UmsAddress::getMemberId, memberId).eq(UmsAddress::getDefaulted, 1).ne(UmsAddress::getId, umsAddress.getId()).set(UmsAddress::getDefaulted, 0));
        }
    }
    return result;
}


@Override
public List<MemberAddressDTO> listCurrentMemberAddresses(){
    Long memberId = SecurityUtils.getMemberId();
    List<UmsAddress> umsAddressList = this.list(new LambdaQueryWrapper<UmsAddress>().eq(UmsAddress::getMemberId, memberId).orderByDesc(// 默认地址排在首位
    UmsAddress::getDefaulted));
    List<MemberAddressDTO> memberAddressList = Optional.ofNullable(umsAddressList).orElse(new ArrayList<>()).stream().map(umsAddress -> {
        MemberAddressDTO memberAddressDTO = new MemberAddressDTO();
        BeanUtil.copyProperties(umsAddress, memberAddressDTO);
        return memberAddressDTO;
    }).collect(Collectors.toList());
    return memberAddressList;
}


}