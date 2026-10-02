package io.gulimall.service.member;
 import com.baomidou.mybatisplus.extension.service.IService;
import io.gulimall.utils.PageUtils;
import io.gulimall.entity.member.MemberReceiveAddressEntity;
import java.util.List;
import java.util.Map;
public interface MemberReceiveAddressService extends IService<MemberReceiveAddressEntity>{


public PageUtils queryPage(Map<String,Object> params)
;

public List<MemberReceiveAddressEntity> getAddressByUserId(Long userId)
;

}