package com.hoangtien2k3.ecommerce.service;
 import com.hoangtien2k3.ecommerce.dto.PaymentRecordDto;
import com.hoangtien2k3.ecommerce.model.notification.PaymentRecord;
import java.util.List;
public interface PaymentRecordService {


public List<PaymentRecord> getAllPayments()
;

public PaymentRecord getPayment(Integer paymentId)
;

public void deletePayment(Integer paymentId)
;

public PaymentRecord savePayment(PaymentRecordDto paymentRecordDto)
;

}