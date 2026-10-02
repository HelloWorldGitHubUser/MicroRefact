package io.gulimall.controller.member;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.member.MemberReceiveAddressEntity;
import io.gulimall.service.member.MemberReceiveAddressService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
import io.gulimall.security.LoginRequired;
@RestController
@RequestMapping("member/memberreceiveaddress")
@LoginRequired
public class MemberReceiveAddressController {

@Autowired
 private  MemberReceiveAddressService memberReceiveAddressService;


@RequestMapping("/save")
public R save(MemberReceiveAddressEntity memberReceiveAddress){
    memberReceiveAddressService.save(memberReceiveAddress);
    return R.ok();
}


@RequestMapping("/update")
public R update(MemberReceiveAddressEntity memberReceiveAddress){
    memberReceiveAddressService.updateById(memberReceiveAddress);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = memberReceiveAddressService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/getAddressByUserId")
public List<MemberReceiveAddressEntity> getAddressByUserId(Long userId){
    return memberReceiveAddressService.getAddressByUserId(userId);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    memberReceiveAddressService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    MemberReceiveAddressEntity memberReceiveAddress = memberReceiveAddressService.getById(id);
    return R.ok().put("memberReceiveAddress", memberReceiveAddress);
}


}