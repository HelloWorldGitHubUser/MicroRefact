package io.gulimall.controller.product;
 import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.gulimall.entity.product.CommentReplayEntity;
import io.gulimall.service.product.CommentReplayService;
import io.gulimall.utils.PageUtils;
import io.gulimall.utils.R;
@RestController
@RequestMapping("product/commentreplay")
public class CommentReplayController {

@Autowired
 private  CommentReplayService commentReplayService;


@RequestMapping("/save")
public R save(CommentReplayEntity commentReplay){
    commentReplayService.save(commentReplay);
    return R.ok();
}


@RequestMapping("/update")
public R update(CommentReplayEntity commentReplay){
    commentReplayService.updateById(commentReplay);
    return R.ok();
}


@RequestMapping("/list")
public R list(Map<String,Object> params){
    PageUtils page = commentReplayService.queryPage(params);
    return R.ok().put("page", page);
}


@RequestMapping("/delete")
public R delete(Long[] ids){
    commentReplayService.removeByIds(Arrays.asList(ids));
    return R.ok();
}


@RequestMapping("/info/{id}")
public R info(Long id){
    CommentReplayEntity commentReplay = commentReplayService.getById(id);
    return R.ok().put("commentReplay", commentReplay);
}


}