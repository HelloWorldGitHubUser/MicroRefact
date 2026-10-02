package com.goodskill.service;
 import com.goodskill.dto.AlipayRequestDTO;
import com.goodskill.dto.AlipayResponseDTO;
import java.util.Map;
public interface AlipayService {


public String handleCallback(Map<String,String> params)
;

public boolean verifyCallbackSignature(Map<String,String> params)
;

public AlipayResponseDTO createPayOrder(AlipayRequestDTO request)
;

public AlipayResponseDTO queryPayStatus(String orderId)
;

}