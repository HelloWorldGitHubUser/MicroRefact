package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.NewBeeMallOrder;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface NewBeeMallOrderMapper {


public int getTotalNewBeeMallOrders(PageQueryUtil pageUtil)
;

public NewBeeMallOrder selectByOrderNo(String orderNo)
;

public int insertSelective(NewBeeMallOrder record)
;

public int updateByPrimaryKeySelective(NewBeeMallOrder record)
;

public int insert(NewBeeMallOrder record)
;

public int closeOrder(List<Long> orderIds,int orderStatus)
;

public int checkDone(List<Long> asList)
;

public List<NewBeeMallOrder> findNewBeeMallOrderList(PageQueryUtil pageUtil)
;

public NewBeeMallOrder selectByPrimaryKey(Long orderId)
;

public List<NewBeeMallOrder> selectByPrimaryKeys(List<Long> orderIds)
;

public int updateByPrimaryKey(NewBeeMallOrder record)
;

public int deleteByPrimaryKey(Long orderId)
;

public int checkOut(List<Long> orderIds)
;

}