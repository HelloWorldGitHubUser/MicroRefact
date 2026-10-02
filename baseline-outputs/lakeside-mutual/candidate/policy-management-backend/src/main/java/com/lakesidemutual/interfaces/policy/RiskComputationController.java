package com.lakesidemutual.interfaces.policy;
 import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lakesidemutual.interfaces.dtos.policy.risk.RiskFactorRequestDto;
import com.lakesidemutual.interfaces.dtos.policy.risk.RiskFactorResponseDto;
@RestController
@RequestMapping("/api/policy/riskfactor")
public class RiskComputationController {

 private  Logger logger;


public int getAge(Date birthday){
    LocalDate birthdayLocalDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate now = LocalDate.now();
    return Period.between(birthdayLocalDate, now).getYears();
}


public int computeLocalityRiskFactor(String postalCodeStr){
    try {
        int postalCode = Integer.parseInt(postalCodeStr);
        if ((postalCode >= 8000 && postalCode < 9000) || (postalCode >= 1000 && postalCode < 2000)) {
            return 80;
        } else if (postalCode >= 5000 && postalCode < 6000) {
            return 10;
        } else {
            return 30;
        }
    } catch (NumberFormatException e) {
        return 0;
    }
}


public int computeRiskFactor(int age,String postalCode){
    int ageGroupRiskFactor = computeAgeGroupRiskFactor(age);
    int localityRiskFactor = computeLocalityRiskFactor(postalCode);
    return (ageGroupRiskFactor + localityRiskFactor) / 2;
}


public int computeAgeGroupRiskFactor(int age){
    if (age > 90) {
        return 100;
    } else if (age > 70) {
        return 90;
    } else if (age > 60) {
        return 70;
    } else if (age > 50) {
        return 60;
    } else if (age > 40) {
        return 50;
    } else if (age > 25) {
        return 20;
    } else {
        return 40;
    }
}


}