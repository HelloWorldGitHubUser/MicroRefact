package ltd.newbee.mall.api.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class NewBeeMallGoodsMapperController {

 private NewBeeMallGoodsMapper newbeemallgoodsmapper;


@GetMapping
("/selectByPrimaryKey")
public NewBeeMallGoods selectByPrimaryKey(@RequestParam(name = "goodsId") Long goodsId){
  return newbeemallgoodsmapper.selectByPrimaryKey(goodsId);
}


@GetMapping
("/selectByPrimaryKeys")
public List<NewBeeMallGoods> selectByPrimaryKeys(@RequestParam(name = "goodsIds") List<Long> goodsIds){
  return newbeemallgoodsmapper.selectByPrimaryKeys(goodsIds);
}


@GetMapping
("/updateStockNum")
public int updateStockNum(@RequestParam(name = "stockNumDTOS") List<StockNumDTO> stockNumDTOS){
  return newbeemallgoodsmapper.updateStockNum(stockNumDTOS);
}


@GetMapping
("/recoverStockNum")
public int recoverStockNum(@RequestParam(name = "stockNumDTOS") List<StockNumDTO> stockNumDTOS){
  return newbeemallgoodsmapper.recoverStockNum(stockNumDTOS);
}


}