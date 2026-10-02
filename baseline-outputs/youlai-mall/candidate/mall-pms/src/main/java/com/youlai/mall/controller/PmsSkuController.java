package com.youlai.mall.controller;
 import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.youlai.mall.result.Result;
import com.youlai.mall.model.pms.entity.PmsSku;
import com.youlai.mall.service.pms.SkuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation;
@Tag(name = "Admin-商品SKU接口")
@RestController
@RequestMapping("/api/v1/sku")
@RequiredArgsConstructor
public class PmsSkuController {

 private  SkuService skuService;


@Operation(summary = "修改SKU")
@PutMapping(value = "/{skuId}")
public Result updateSku(Long skuId,PmsSku sku){
    boolean result = skuService.updateById(sku);
    return Result.judge(result);
}


@Operation(summary = "商品SKU详情")
@GetMapping("/{skuId}")
public Result getSkuDetail(Long skuId){
    PmsSku sku = skuService.getById(skuId);
    return Result.success(sku);
}


}