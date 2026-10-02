package com.youlai.mall.controller;
 import com.baomidou.mybatisplus.core.metadata.IPage;
import com.youlai.mall.result.PageResult;
import com.youlai.mall.result.Result;
import com.youlai.mall.model.pms.form.PmsSpuForm;
import com.youlai.mall.model.pms.query.SpuPageQuery;
import com.youlai.mall.model.pms.vo.PmsSpuDetailVO;
import com.youlai.mall.model.pms.vo.PmsSpuPageVO;
import com.youlai.mall.service.pms.SpuService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation;
@Tag(name = "Admin-商品SPU接口")
@RestController
@RequestMapping("/api/v1/spu")
@AllArgsConstructor
public class PmsSpuController {

 private  SpuService spuService;


@Operation(summary = "修改商品")
@PutMapping(value = "/{id}")
public Result updateSpuById(Long id,PmsSpuForm formData){
    boolean result = spuService.updateSpuById(id, formData);
    return Result.judge(result);
}


@Operation(summary = "新增商品")
@PostMapping
public Result addSpu(PmsSpuForm formData){
    boolean result = spuService.addSpu(formData);
    return Result.judge(result);
}


@Operation(summary = "商品分页列表")
@GetMapping("/page")
public PageResult listPagedSpu(SpuPageQuery queryParams){
    IPage<PmsSpuPageVO> result = spuService.listPagedSpu(queryParams);
    return PageResult.success(result);
}


@Operation(summary = "商品详情")
@GetMapping("/{id}/detail")
public Result detail(Long id){
    PmsSpuDetailVO pmsSpuDetailVO = spuService.getSpuDetail(id);
    return Result.success(pmsSpuDetailVO);
}


@Operation(summary = "删除商品")
@DeleteMapping("/{ids}")
public Result delete(String ids){
    boolean result = spuService.removeBySpuIds(ids);
    return Result.judge(result);
}


}