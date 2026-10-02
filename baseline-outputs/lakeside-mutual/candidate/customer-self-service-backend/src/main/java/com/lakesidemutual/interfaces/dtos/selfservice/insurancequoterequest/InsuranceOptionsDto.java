package com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest;
 import java.util.Date;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lakesidemutual.domain.selfservice.InsuranceOptionsEntity;
import com.lakesidemutual.domain.selfservice.InsuranceType;
public class InsuranceOptionsDto {

@Valid
@NotNull
@JsonFormat(pattern = "yyyy-MM-dd")
 private  Date startDate;

@NotEmpty
 private  String insuranceType;

@Valid
@NotNull
 private  MoneyAmountDto deductible;

public InsuranceOptionsDto() {
}private InsuranceOptionsDto(Date startDate, String insuranceType, MoneyAmountDto deductible) {
    this.startDate = startDate;
    this.insuranceType = insuranceType;
    this.deductible = deductible;
}
public void setDeductible(MoneyAmountDto deductible){
    this.deductible = deductible;
}


public Date getStartDate(){
    return startDate;
}


public void setStartDate(Date startDate){
    this.startDate = startDate;
}


public String getInsuranceType(){
    return insuranceType;
}


public InsuranceOptionsEntity toDomainObject(){
    return new InsuranceOptionsEntity(startDate, new InsuranceType(insuranceType), deductible.toDomainObject());
}


public void setInsuranceType(String insuranceType){
    this.insuranceType = insuranceType;
}


public MoneyAmountDto getDeductible(){
    return deductible;
}


public InsuranceOptionsDto fromDomainObject(InsuranceOptionsEntity insuranceOptions){
    Date startDate = insuranceOptions.getStartDate();
    InsuranceType insuranceType = insuranceOptions.getInsuranceType();
    String insuranceTypeDto = insuranceType.getName();
    MoneyAmountDto deductibleDto = MoneyAmountDto.fromDomainObject(insuranceOptions.getDeductible());
    return new InsuranceOptionsDto(startDate, insuranceTypeDto, deductibleDto);
}


}