package com.youlai.mall.service.ums;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.youlai.mall.model.pms.vo.ProductHistoryVO;
import com.youlai.mall.model.ums.dto.MemberAddressDTO;
import com.youlai.mall.model.ums.dto.MemberAuthDTO;
import com.youlai.mall.model.ums.dto.MemberRegisterDto;
import com.youlai.mall.model.ums.dto.MemberInfoDTO;
import com.youlai.mall.model.ums.entity.UmsMember;
import com.youlai.mall.model.ums.vo.MemberVO;
import java.util.List;
import java.util.Set;
public interface UmsMemberService extends IService<UmsMember>{


public List<MemberAddressDTO> listMemberAddresses(Long memberId){
    return listMemberAddress(memberId);
}
;

public Long addMember(MemberRegisterDto member)
;

public MemberAuthDTO getMemberByMobile(String mobile)
;

public void addProductViewHistory(ProductHistoryVO vo){
    // 从SecurityUtils获取当前用户ID
    addProductViewHistory(vo, null);
}
;

public IPage<UmsMember> list(Page<UmsMember> page,String nickname)
;

public MemberAuthDTO getMemberByOpenid(String openid)
;

public void deductBalance(Long memberId,Long amount)
;

public MemberAuthDTO loadUserByMobile(String mobile){
    return getMemberByMobile(mobile);
}
;

public MemberAuthDTO loadUserByOpenId(String openid){
    return getMemberByOpenid(openid);
}
;

public String getMemberOpenId(Long memberId)
;

public List<MemberAddressDTO> listMemberAddress(Long memberId)
;

public Long registerMember(MemberRegisterDto dto){
    return addMember(dto);
}
;

public Set<ProductHistoryVO> getProductViewHistory(Long userId)
;

public MemberVO getCurrMemberInfo()
;

}