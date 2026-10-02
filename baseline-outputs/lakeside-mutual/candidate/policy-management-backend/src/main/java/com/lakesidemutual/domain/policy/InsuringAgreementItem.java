package com.lakesidemutual.domain.policy;
 import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.microserviceapipatterns.domaindrivendesign.ValueObject;
@Entity(name = "PolicyInsuringAgreementItem")
@jakarta.persistence.Table(name = "pm_insuring_agreement_item")
public class InsuringAgreementItem implements ValueObject{

@GeneratedValue
@Id
 private  Long id;

 private  String title;

 private  String description;

public InsuringAgreementItem() {
    this.title = null;
    this.description = null;
}public InsuringAgreementItem(String title, String description) {
    this.title = title;
    this.description = description;
}
public String getTitle(){
    return title;
}


@Override
public int hashCode(){
    return Objects.hash(title, description);
}


@Override
public boolean equals(Object obj){
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    InsuringAgreementItem other = (InsuringAgreementItem) obj;
    return Objects.equals(title, other.title) && Objects.equals(description, other.description);
}


public void setId(Long id){
    this.id = id;
}


public Long getId(){
    return id;
}


public String getDescription(){
    return description;
}


}