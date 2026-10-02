package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class InsuranceQuoteResponseApplicationEventController {

 private InsuranceQuoteResponseApplicationEvent insurancequoteresponseapplicationevent;

 private InsuranceQuoteResponseApplicationEvent insurancequoteresponseapplicationevent;


@GetMapping
("/isRequestAccepted")
public boolean isRequestAccepted(){
  return insurancequoteresponseapplicationevent.isRequestAccepted();
}


}