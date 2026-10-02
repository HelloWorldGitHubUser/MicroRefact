package ltd.newbee.mall.api.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ltd.newbee.mall.api.Interface.NewBeeMallGoodsMapper;
public class NewBeeMallGoodsMapperImpl implements NewBeeMallGoodsMapper{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://1";


public List<NewBeeMallGoods> selectByPrimaryKeys(List<Long> goodsIds){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/selectByPrimaryKeys"))
    .queryParam("goodsIds",goodsIds)
;  List<NewBeeMallGoods> aux = restTemplate.getForObject(builder.toUriString(), List<NewBeeMallGoods>.class);

 return aux;
}


public int updateStockNum(List<StockNumDTO> stockNumDTOS){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/updateStockNum"))
    .queryParam("stockNumDTOS",stockNumDTOS)
;  int aux = restTemplate.getForObject(builder.toUriString(), int.class);

 return aux;
}


public int recoverStockNum(List<StockNumDTO> stockNumDTOS){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/recoverStockNum"))
    .queryParam("stockNumDTOS",stockNumDTOS)
;  int aux = restTemplate.getForObject(builder.toUriString(), int.class);

 return aux;
}


}