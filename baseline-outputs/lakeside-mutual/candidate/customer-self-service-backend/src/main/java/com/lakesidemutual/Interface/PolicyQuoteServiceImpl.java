package com.lakesidemutual.Interface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.lakesidemutual.Interface.PolicyQuoteService;
public class PolicyQuoteServiceImpl implements PolicyQuoteService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://3";


public void receiveInsuranceQuoteRequest(InsuranceQuoteRequestDto insuranceQuoteRequestDto){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/receiveInsuranceQuoteRequest"))
    .queryParam("insuranceQuoteRequestDto",insuranceQuoteRequestDto)
;
  restTemplate.put(builder.toUriString(), null);
}


public void handleCustomerDecision(Long insuranceQuoteRequestId,boolean quoteAccepted,Date decisionDate){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/handleCustomerDecision"))
    .queryParam("insuranceQuoteRequestId",insuranceQuoteRequestId)
    .queryParam("quoteAccepted",quoteAccepted)
    .queryParam("decisionDate",decisionDate)
;
  restTemplate.put(builder.toUriString(), null);
}


}