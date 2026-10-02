package ltd.newbee.mall.api.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ltd.newbee.mall.api.Interface.NewBeeMallGoodsMapper;
public class NewBeeMallGoodsMapperImpl implements NewBeeMallGoodsMapper{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://1";


public NewBeeMallGoods selectByPrimaryKey(Long goodsId){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/selectByPrimaryKey"))
    .queryParam("goodsId",goodsId)
;  NewBeeMallGoods aux = restTemplate.getForObject(builder.toUriString(), NewBeeMallGoods.class);

 return aux;
}


public List<NewBeeMallGoods> selectByPrimaryKeys(List<Long> goodsIds){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/selectByPrimaryKeys"))
    .queryParam("goodsIds",goodsIds)
;  List<NewBeeMallGoods> aux = restTemplate.getForObject(builder.toUriString(), List<NewBeeMallGoods>.class);

 return aux;
}


}