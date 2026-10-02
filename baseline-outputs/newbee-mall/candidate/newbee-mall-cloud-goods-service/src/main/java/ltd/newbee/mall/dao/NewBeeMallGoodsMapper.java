package ltd.newbee.mall.dao;
 import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.StockNumDTO;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface NewBeeMallGoodsMapper {


public int getTotalNewBeeMallGoodsBySearch(PageQueryUtil pageUtil)
;

public List<NewBeeMallGoods> findNewBeeMallGoodsList(PageQueryUtil pageUtil)
;

public int getTotalNewBeeMallGoods(PageQueryUtil pageUtil)
;

public int insertSelective(NewBeeMallGoods record)
;

public int updateByPrimaryKeySelective(NewBeeMallGoods record)
;

public int batchInsert(List<NewBeeMallGoods> newBeeMallGoodsList)
;

public int insert(NewBeeMallGoods record)
;

public NewBeeMallGoods selectByCategoryIdAndName(String goodsName,Long goodsCategoryId)
;

public int updateByPrimaryKeyWithBLOBs(NewBeeMallGoods record)
;

public List<NewBeeMallGoods> findNewBeeMallGoodsListBySearch(PageQueryUtil pageUtil)
;

public NewBeeMallGoods selectByPrimaryKey(Long goodsId)
;

public List<NewBeeMallGoods> selectByPrimaryKeys(List<Long> goodsIds)
;

public int batchUpdateSellStatus(Long[] orderIds,int sellStatus)
;

public int updateByPrimaryKey(NewBeeMallGoods record)
;

public int deleteByPrimaryKey(Long goodsId)
;

public int recoverStockNum(List<StockNumDTO> stockNumDTOS)
;

public int updateStockNum(List<StockNumDTO> stockNumDTOS)
;

}