package ltd.newbee.mall.api.Interface;
public interface NewBeeMallGoodsMapper {

   public NewBeeMallGoods selectByPrimaryKey(Long goodsId);
   public List<NewBeeMallGoods> selectByPrimaryKeys(List<Long> goodsIds);
}