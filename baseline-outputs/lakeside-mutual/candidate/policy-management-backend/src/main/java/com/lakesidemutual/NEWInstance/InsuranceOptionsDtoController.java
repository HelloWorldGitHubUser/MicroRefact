package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class InsuranceOptionsDtoController {

 private InsuranceOptionsDto insuranceoptionsdto;

 private InsuranceOptionsDto insuranceoptionsdto;


@PutMapping
("/setInsuranceType")
public void setInsuranceType(@RequestParam(name = "insuranceType") String insuranceType){
insuranceoptionsdto.setInsuranceType(insuranceType);
}


@PutMapping
("/setDeductible")
public void setDeductible(@RequestParam(name = "deductible") MoneyAmountDto deductible){
insuranceoptionsdto.setDeductible(deductible);
}


}