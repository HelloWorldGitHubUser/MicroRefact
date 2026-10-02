package ltd.newbee.mall.api.Interface;
public interface NewBeeMallShoppingCartService {

   public List<NewBeeMallShoppingCartItemVO> getCartItemsForSettle(List<Long> cartItemIds,Long newBeeMallUserId);
}