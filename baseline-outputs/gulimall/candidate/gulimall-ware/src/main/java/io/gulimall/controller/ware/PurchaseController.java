package io.gulimall.controller.ware;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.gulimall.vo.ware.MergeVo;
import io.gulimall.vo.ware.PurchaseDoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import io.gulimall.entity.ware.PurchaseEntity;
import io.gulimall.service.ware.PurchaseService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
import io.gulimall.DTO.R;
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {

@Autowired
 private  PurchaseService purchaseService;


@PostMapping("/received")
public R ReceivedPurchase(List<Long> ids){
    purchaseService.ReceivedPurchase(ids);
    return R.ok();
}


@PostMapping("/merge")
public R mergePurchaseDetail(MergeVo mergeVo){
    purchaseService.mergePurchaseDetail(mergeVo);
    return R.ok();
}


@RequestMapping("/save")
public R save(PurchaseEntity purchase){
    purchaseService.save(purchase);
    return R.ok();
}


@PostMapping("/done")
public R finishPurchase(PurchaseDoneVo purchaseDoneVo){
    purchaseService.finishPurchase(purchaseDoneVo);
    return R.ok();
}


@RequestMapping("/update")
public R update(PurchaseEntity purchase){
    purchaseService.updateById(purchase);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = purchaseService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    purchaseService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    PurchaseEntity purchase = purchaseService.getById(id);
    return R.ok().put("purchase", purchase);
}


@RequestMapping("/unreceive/list")
public R listUnreceive(Map<String,Object> params){
    PageUtils page = purchaseService.listUnreceive(params);
    return R.ok().put("page", page);
}


}