package com.goodskill.service;
 import com.goodskill.dto.GoodsDTO;
import java.util.List;
public interface GoodsEsService {


public void saveBatch(List<GoodsDTO> list)
;

public List<GoodsDTO> searchWithNameByPage(String input)
;

public void save(GoodsDTO goodsDto)
;

public void delete(GoodsDTO goodsDto)
;

}