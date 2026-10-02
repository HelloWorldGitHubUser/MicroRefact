package io.gulimall.controller.ware;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.ware.PurchaseDetailEntity;
import io.gulimall.service.ware.PurchaseDetailService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("ware/purchasedetail")
public class PurchaseDetailController {

@Autowired
 private  PurchaseDetailService purchaseDetailService;


@RequestMapping("/save")
public R save(PurchaseDetailEntity purchaseDetail){
    purchaseDetailService.save(purchaseDetail);
    return R.ok();
}


@RequestMapping("/update")
public R update(PurchaseDetailEntity purchaseDetail){
    purchaseDetailService.updateById(purchaseDetail);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = purchaseDetailService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    purchaseDetailService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    PurchaseDetailEntity purchaseDetail = purchaseDetailService.getById(id);
    return R.ok().put("purchaseDetail", purchaseDetail);
}


}