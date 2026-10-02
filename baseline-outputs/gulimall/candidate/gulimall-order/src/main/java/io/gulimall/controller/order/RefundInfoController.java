package io.gulimall.controller.order;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.order.RefundInfoEntity;
import io.gulimall.service.order.RefundInfoService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("order/refundinfo")
public class RefundInfoController {

@Autowired
 private  RefundInfoService refundInfoService;


@RequestMapping("/save")
public R save(RefundInfoEntity refundInfo){
    refundInfoService.save(refundInfo);
    return R.ok();
}


@RequestMapping("/update")
public R update(RefundInfoEntity refundInfo){
    refundInfoService.updateById(refundInfo);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = refundInfoService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    refundInfoService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    RefundInfoEntity refundInfo = refundInfoService.getById(id);
    return R.ok().put("refundInfo", refundInfo);
}


}