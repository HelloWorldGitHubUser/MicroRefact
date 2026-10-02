package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.PaymentDto;
import org.springframework.data.domain.Page;
import java.util.List;
public interface PaymentService {


public PaymentDto findById(Integer paymentId)
;

public PaymentDto save(PaymentDto paymentDto)
;

public void deleteById(Integer paymentId)
;

public PaymentDto update(Integer paymentId,PaymentDto paymentDto)
;

public Page<PaymentDto> findAll(int page,int size,String sortBy,String sortOrder)
;

}