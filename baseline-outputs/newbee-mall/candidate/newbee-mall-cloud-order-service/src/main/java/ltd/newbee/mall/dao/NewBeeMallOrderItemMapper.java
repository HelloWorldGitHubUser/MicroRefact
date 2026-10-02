package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.NewBeeMallOrderItem;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface NewBeeMallOrderItemMapper {


public NewBeeMallOrderItem selectByPrimaryKey(Long orderItemId)
;

public int insertSelective(NewBeeMallOrderItem record)
;

public int updateByPrimaryKeySelective(NewBeeMallOrderItem record)
;

public int updateByPrimaryKey(NewBeeMallOrderItem record)
;

public int insert(NewBeeMallOrderItem record)
;

public List<NewBeeMallOrderItem> selectByOrderId(Long orderId)
;

public int insertBatch(List<NewBeeMallOrderItem> orderItems)
;

public int deleteByPrimaryKey(Long orderItemId)
;

public List<NewBeeMallOrderItem> selectByOrderIds(List<Long> orderIds)
;

}