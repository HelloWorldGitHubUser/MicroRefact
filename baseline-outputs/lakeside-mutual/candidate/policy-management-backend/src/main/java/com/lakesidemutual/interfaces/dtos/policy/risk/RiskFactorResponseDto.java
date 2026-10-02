package com.lakesidemutual.interfaces.dtos.policy.risk;
 public class RiskFactorResponseDto {

 private  int riskFactor;

public RiskFactorResponseDto(int riskFactor) {
    this.riskFactor = riskFactor;
}
public int getRiskFactor(){
    return riskFactor;
}


}