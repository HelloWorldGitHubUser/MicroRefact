package ltd.newbee.mall.api.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class NewBeeMallShoppingCartServiceController {

 private NewBeeMallShoppingCartService newbeemallshoppingcartservice;


@GetMapping
("/getCartItemsForSettle")
public List<NewBeeMallShoppingCartItemVO> getCartItemsForSettle(@RequestParam(name = "cartItemIds") List<Long> cartItemIds,@RequestParam(name = "newBeeMallUserId") Long newBeeMallUserId){
  return newbeemallshoppingcartservice.getCartItemsForSettle(cartItemIds,newBeeMallUserId);
}


}