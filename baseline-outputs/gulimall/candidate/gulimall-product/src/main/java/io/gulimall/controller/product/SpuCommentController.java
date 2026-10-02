package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.SpuCommentEntity;
import io.gulimall.service.product.SpuCommentService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/spucomment")
public class SpuCommentController {

@Autowired
 private  SpuCommentService spuCommentService;


@RequestMapping("/save")
public R save(SpuCommentEntity spuComment){
    spuCommentService.save(spuComment);
    return R.ok();
}


@RequestMapping("/update")
public R update(SpuCommentEntity spuComment){
    spuCommentService.updateById(spuComment);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = spuCommentService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    spuCommentService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    SpuCommentEntity spuComment = spuCommentService.getById(id);
    return R.ok().put("spuComment", spuComment);
}


}