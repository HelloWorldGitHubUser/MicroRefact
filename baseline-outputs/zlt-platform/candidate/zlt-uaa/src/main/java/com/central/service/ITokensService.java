package com.central.service;
 import com.central.model.PageResult;
import com.central.model.vo.TokenVo;
import java.util.Map;
public interface ITokensService {


public PageResult<TokenVo> listTokens(Map<String,Object> params,String clientId)
;

}