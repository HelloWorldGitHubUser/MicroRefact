package com.lakesidemutual.interfaces.dtos.policy.policy;
 import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.lakesidemutual.domain.policy.InsuringAgreementEntity;
import com.lakesidemutual.domain.policy.InsuringAgreementItem;
public class InsuringAgreementDto {

@Valid
@NotNull
 private  List<InsuringAgreementItemDto> agreementItems;

public InsuringAgreementDto() {
    this.agreementItems = null;
}public InsuringAgreementDto(List<InsuringAgreementItemDto> agreementItems) {
    this.agreementItems = agreementItems;
}
public List<InsuringAgreementItemDto> getAgreementItems(){
    return agreementItems;
}


public InsuringAgreementEntity toDomainObject(){
    List<InsuringAgreementItem> insuringAgreementItems = getAgreementItems().stream().map(InsuringAgreementItemDto::toDomainObject).collect(Collectors.toList());
    return new InsuringAgreementEntity(insuringAgreementItems);
}


public InsuringAgreementDto fromDomainObject(InsuringAgreementEntity insuringAgreement){
    List<InsuringAgreementItemDto> insuringAgreementItemDtos = insuringAgreement.getAgreementItems().stream().map(InsuringAgreementItemDto::fromDomainObject).collect(Collectors.toList());
    return new InsuringAgreementDto(insuringAgreementItemDtos);
}


}