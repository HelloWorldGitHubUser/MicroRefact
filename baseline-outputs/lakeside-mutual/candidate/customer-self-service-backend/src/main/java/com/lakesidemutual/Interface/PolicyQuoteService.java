package com.lakesidemutual.Interface;
public interface PolicyQuoteService {

   public void receiveInsuranceQuoteRequest(InsuranceQuoteRequestDto insuranceQuoteRequestDto);
   public void handleCustomerDecision(Long insuranceQuoteRequestId,boolean quoteAccepted,Date decisionDate);
}