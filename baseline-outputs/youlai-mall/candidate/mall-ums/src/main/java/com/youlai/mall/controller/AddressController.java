package com.youlai.mall.controller;
 import com.youlai.mall.result.Result;
import com.youlai.mall.model.ums.dto.MemberAddressDTO;
import com.youlai.mall.model.ums.entity.UmsAddress;
import com.youlai.mall.model.ums.form.AddressForm;
import com.youlai.mall.service.ums.UmsAddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation;
import java.util.Arrays;
import java.util.List;
import com.youlai.mall.DTO.Result;
@Tag(name = "App-会员地址")
@RestController
@RequestMapping("/app-api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

 private  UmsAddressService addressService;


@Operation(summary = "修改地址")
@PutMapping("/{addressId}")
public Result updateAddress(Long addressId,AddressForm addressForm){
    boolean result = addressService.updateAddress(addressForm);
    return Result.judge(result);
}


@Operation(summary = "新增地址")
@PostMapping
public Result addAddress(AddressForm addressForm){
    boolean result = addressService.addAddress(addressForm);
    return Result.judge(result);
}


@Operation(summary = "获取当前会员地址列表")
@GetMapping
public Result<List<MemberAddressDTO>> listCurrentMemberAddresses(){
    List<MemberAddressDTO> addressList = addressService.listCurrentMemberAddresses();
    return Result.success(addressList);
}


@Operation(summary = "获取地址详情")
@GetMapping("/{addressId}")
public Result<UmsAddress> getAddressDetail(Long addressId){
    UmsAddress umsAddress = addressService.getById(addressId);
    return Result.success(umsAddress);
}


@Operation(summary = "删除地址")
@DeleteMapping("/{ids}")
public Result deleteAddress(String ids){
    boolean status = addressService.removeByIds(Arrays.asList(ids.split(",")));
    return Result.judge(status);
}


}