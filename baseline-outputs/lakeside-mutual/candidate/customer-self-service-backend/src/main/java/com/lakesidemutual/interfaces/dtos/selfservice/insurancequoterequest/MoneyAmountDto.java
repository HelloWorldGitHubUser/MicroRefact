package com.lakesidemutual.interfaces.dtos.selfservice.insurancequoterequest;
 import java.math.BigDecimal;
import java.util.Currency;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import com.lakesidemutual.domain.selfservice.MoneyAmount;
public class MoneyAmountDto {

@NotNull
@DecimalMax(value = "1000000000000", inclusive = false)
@DecimalMin("0")
 private  BigDecimal amount;

@NotEmpty
 private  String currency;

public MoneyAmountDto() {
}private MoneyAmountDto(BigDecimal amount, String currency) {
    this.amount = amount;
    this.currency = currency;
}
public String getCurrency(){
    return currency;
}


public MoneyAmount toDomainObject(){
    return new MoneyAmount(amount, Currency.getInstance(currency));
}


public void setAmount(BigDecimal amount){
    this.amount = amount;
}


public void setCurrency(String currency){
    this.currency = currency;
}


public MoneyAmountDto fromDomainObject(MoneyAmount moneyAmount){
    return new MoneyAmountDto(moneyAmount.getAmount(), moneyAmount.getCurrency().toString());
}


public BigDecimal getAmount(){
    return amount;
}


}