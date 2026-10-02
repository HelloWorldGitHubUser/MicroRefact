package io.gulimall.controller.ware;
 import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.gulimall.exception.BizCodeEnum;
import io.gulimall.exception.NoStockException;
import io.gulimall.vo.SkuHasStockVo;
import io.gulimall.vo.WareSkuLockVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.ware.WareSkuEntity;
import io.gulimall.service.ware.WareSkuService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("ware/waresku")
public class WareSkuController {

@Autowired
 private  WareSkuService wareSkuService;


@RequestMapping("/save")
public R save(WareSkuEntity wareSku){
    wareSkuService.save(wareSku);
    return R.ok();
}


@RequestMapping("/update")
public R update(WareSkuEntity wareSku){
    wareSkuService.updateById(wareSku);
    return R.ok();
}


@RequestMapping("/lock/order")
public R orderLockStock(WareSkuLockVo lockVo){
    try {
        Boolean lock = wareSkuService.orderLockStock(lockVo);
        return R.ok();
    } catch (NoStockException e) {
        return R.error(BizCodeEnum.NO_STOCK_EXCEPTION.getCode(), BizCodeEnum.NO_STOCK_EXCEPTION.getMsg());
    }
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = wareSkuService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/getSkuHasStocks")
public List<SkuHasStockVo> getSkuHasStocks(List<Long> ids){
    return wareSkuService.getSkuHasStocks(ids);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    wareSkuService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    WareSkuEntity wareSku = wareSkuService.getById(id);
    return R.ok().put("wareSku", wareSku);
}


}