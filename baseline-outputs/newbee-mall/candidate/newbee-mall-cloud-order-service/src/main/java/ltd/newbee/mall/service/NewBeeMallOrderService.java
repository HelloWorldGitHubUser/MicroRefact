package ltd.newbee.mall.service;
 import ltd.newbee.mall.api.mall.vo.NewBeeMallOrderDetailVO;
import ltd.newbee.mall.api.mall.vo.NewBeeMallOrderItemVO;
import ltd.newbee.mall.api.mall.vo.NewBeeMallShoppingCartItemVO;
import ltd.newbee.mall.entity.MallUser;
import ltd.newbee.mall.entity.MallUserAddress;
import ltd.newbee.mall.entity.NewBeeMallOrder;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import java.util.List;
public interface NewBeeMallOrderService {


public PageResult getNewBeeMallOrdersPage(PageQueryUtil pageUtil)
;

public String cancelOrder(String orderNo,Long userId)
;

public String saveOrder(MallUser loginMallUser,MallUserAddress address,List<NewBeeMallShoppingCartItemVO> itemsForSave)
;

public List<NewBeeMallOrderItemVO> getOrderItems(Long orderId)
;

public NewBeeMallOrderDetailVO getOrderDetailByOrderNo(String orderNo,Long userId)
;

public String closeOrder(Long[] ids)
;

public NewBeeMallOrderDetailVO getOrderDetailByOrderId(Long orderId)
;

public String updateOrderInfo(NewBeeMallOrder newBeeMallOrder)
;

public String finishOrder(String orderNo,Long userId)
;

public String paySuccess(String orderNo,int payType)
;

public String checkDone(Long[] ids)
;

public PageResult getMyOrders(PageQueryUtil pageUtil)
;

public String checkOut(Long[] ids)
;

}