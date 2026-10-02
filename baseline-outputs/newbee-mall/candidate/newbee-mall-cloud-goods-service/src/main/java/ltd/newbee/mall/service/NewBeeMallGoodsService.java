package ltd.newbee.mall.service;
 import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import java.util.List;
public interface NewBeeMallGoodsService {


public String updateNewBeeMallGoods(NewBeeMallGoods goods)
;

public PageResult searchNewBeeMallGoods(PageQueryUtil pageUtil)
;

public Boolean batchUpdateSellStatus(Long[] ids,int sellStatus)
;

public void batchSaveNewBeeMallGoods(List<NewBeeMallGoods> newBeeMallGoodsList)
;

public NewBeeMallGoods getNewBeeMallGoodsById(Long id)
;

public String saveNewBeeMallGoods(NewBeeMallGoods goods)
;

public PageResult getNewBeeMallGoodsPage(PageQueryUtil pageUtil)
;

}