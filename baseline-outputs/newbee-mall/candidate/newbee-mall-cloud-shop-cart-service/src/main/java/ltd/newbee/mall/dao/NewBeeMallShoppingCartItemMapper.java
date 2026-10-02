package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.NewBeeMallShoppingCartItem;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface NewBeeMallShoppingCartItemMapper {


public List<NewBeeMallShoppingCartItem> selectByUserId(Long newBeeMallUserId,int number)
;

public int insertSelective(NewBeeMallShoppingCartItem record)
;

public int updateByPrimaryKeySelective(NewBeeMallShoppingCartItem record)
;

public int insert(NewBeeMallShoppingCartItem record)
;

public List<NewBeeMallShoppingCartItem> selectByUserIdAndCartItemIds(Long newBeeMallUserId,List<Long> cartItemIds)
;

public int getTotalMyNewBeeMallCartItems(PageQueryUtil pageUtil)
;

public List<NewBeeMallShoppingCartItem> findMyNewBeeMallCartItems(PageQueryUtil pageUtil)
;

public int deleteBatch(List<Long> ids)
;

public int selectCountByUserId(Long newBeeMallUserId)
;

public NewBeeMallShoppingCartItem selectByUserIdAndGoodsId(Long newBeeMallUserId,Long goodsId)
;

public NewBeeMallShoppingCartItem selectByPrimaryKey(Long cartItemId)
;

public int updateByPrimaryKey(NewBeeMallShoppingCartItem record)
;

public int deleteByPrimaryKey(Long cartItemId)
;

}