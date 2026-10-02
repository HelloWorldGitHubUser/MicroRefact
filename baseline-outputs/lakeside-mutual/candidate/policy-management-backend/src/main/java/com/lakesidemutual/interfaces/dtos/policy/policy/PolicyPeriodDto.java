package com.lakesidemutual.interfaces.dtos.policy.policy;
 import java.util.Date;
import jakarta.validation.constraints.NotNull;
import com.lakesidemutual.domain.policy.PolicyPeriod;
public class PolicyPeriodDto {

@NotNull
 private  Date startDate;

@NotNull
 private  Date endDate;

public PolicyPeriodDto() {
}public PolicyPeriodDto(Date startDate, Date endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
}
public Date getStartDate(){
    return startDate;
}


public void setStartDate(Date startDate){
    this.startDate = startDate;
}


public PolicyPeriod toDomainObject(){
    return new PolicyPeriod(startDate, endDate);
}


public Date getEndDate(){
    return endDate;
}


public void setEndDate(Date endDate){
    this.endDate = endDate;
}


public PolicyPeriodDto fromDomainObject(PolicyPeriod policyPeriod){
    return new PolicyPeriodDto(policyPeriod.getStartDate(), policyPeriod.getEndDate());
}


}