package com.goodskill.service;
 import com.goodskill.vo.GoodsVO;
import java.io.Serializable;
import java.util.List;
public interface GoodsService {


public void addGoods(GoodsVO goods)
;

public GoodsVO findById(Serializable goodsId)
;

public List<GoodsVO> findMany()
;

public void uploadGoodsPhoto(long goodsId,String fileUrl)
;

}