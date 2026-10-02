package com.lakesidemutual.interfaces.dtos.policy.policy;
 import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import com.lakesidemutual.domain.policy.InsuringAgreementItem;
public class InsuringAgreementItemDto {

@Valid
@NotEmpty
 private  String title;

@Valid
@NotEmpty
 private  String description;

public InsuringAgreementItemDto() {
    this.title = null;
    this.description = null;
}private InsuringAgreementItemDto(String title, String description) {
    this.title = title;
    this.description = description;
}
public String getTitle(){
    return title;
}


public InsuringAgreementItem toDomainObject(){
    return new InsuringAgreementItem(title, description);
}


public String getDescription(){
    return description;
}


public InsuringAgreementItemDto fromDomainObject(InsuringAgreementItem item){
    return new InsuringAgreementItemDto(item.getTitle(), item.getDescription());
}


}