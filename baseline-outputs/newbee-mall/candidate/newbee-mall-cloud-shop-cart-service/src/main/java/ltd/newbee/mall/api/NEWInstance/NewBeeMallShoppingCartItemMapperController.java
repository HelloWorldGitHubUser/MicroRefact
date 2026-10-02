package ltd.newbee.mall.api.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class NewBeeMallShoppingCartItemMapperController {

 private NewBeeMallShoppingCartItemMapper newbeemallshoppingcartitemmapper;


@GetMapping
("/deleteBatch")
public int deleteBatch(@RequestParam(name = "ids") List<Long> ids){
  return newbeemallshoppingcartitemmapper.deleteBatch(ids);
}


}