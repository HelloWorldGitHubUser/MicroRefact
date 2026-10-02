package ltd.newbee.mall.service;
 import ltd.newbee.mall.api.mall.param.SaveCartItemParam;
import ltd.newbee.mall.api.mall.param.UpdateCartItemParam;
import ltd.newbee.mall.api.mall.vo.NewBeeMallShoppingCartItemVO;
import ltd.newbee.mall.entity.NewBeeMallShoppingCartItem;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import java.util.List;
public interface NewBeeMallShoppingCartService {


public NewBeeMallShoppingCartItem getNewBeeMallCartItemById(Long newBeeMallShoppingCartItemId)
;

public List<NewBeeMallShoppingCartItemVO> getCartItemsForSettle(List<Long> cartItemIds,Long newBeeMallUserId)
;

public Boolean deleteById(Long shoppingCartItemId,Long userId)
;

public PageResult getMyShoppingCartItems(PageQueryUtil pageUtil)
;

public String saveNewBeeMallCartItem(SaveCartItemParam saveCartItemParam,Long userId)
;

public String updateNewBeeMallCartItem(UpdateCartItemParam updateCartItemParam,Long userId)
;

}