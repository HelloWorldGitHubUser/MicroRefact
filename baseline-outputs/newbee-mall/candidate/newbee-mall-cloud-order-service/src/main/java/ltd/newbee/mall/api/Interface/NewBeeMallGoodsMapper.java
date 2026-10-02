package ltd.newbee.mall.api.Interface;
public interface NewBeeMallGoodsMapper {

   public List<NewBeeMallGoods> selectByPrimaryKeys(List<Long> goodsIds);
   public int updateStockNum(List<StockNumDTO> stockNumDTOS);
   public int recoverStockNum(List<StockNumDTO> stockNumDTOS);
}