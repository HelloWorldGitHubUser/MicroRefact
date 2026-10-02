package io.gulimall.controller.product;
 import io.gulimall.service.product.SkuInfoService;
import io.gulimall.vo.product.SkuItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class ItemController {

@Autowired
 private  SkuInfoService skuInfoService;


@GetMapping("/{skuId:\\d+}.html")
public String skuItem(Long skuId,Model model){
    SkuItemVo skuItemVo = skuInfoService.item(skuId);
    model.addAttribute("item", skuItemVo);
    return "product/templates/item";
}


}