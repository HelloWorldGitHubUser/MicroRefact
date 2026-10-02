package com.goodskill.repository.es;
 import com.goodskill.entity.es.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
public interface GoodsRepository extends ElasticsearchRepository<Goods, String>{


public void deleteByGoodsId(Integer goodsId)
;

}