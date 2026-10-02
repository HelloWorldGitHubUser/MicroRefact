package com.lakesidemutual.domain.policy;
 import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity(name = "PolicyInsuringAgreementEntity")
@jakarta.persistence.Table(name = "pm_insuring_agreement")
public class InsuringAgreementEntity {

@GeneratedValue
@Id
 private  Long id;

@OneToMany(cascade = CascadeType.ALL)
 private  List<InsuringAgreementItem> agreementItems;

public InsuringAgreementEntity() {
    this.agreementItems = null;
}public InsuringAgreementEntity(List<InsuringAgreementItem> agreementItems) {
    this.agreementItems = agreementItems;
}
public List<InsuringAgreementItem> getAgreementItems(){
    return agreementItems;
}


@Override
public int hashCode(){
    return Objects.hashCode(new ArrayList<>(agreementItems));
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
    InsuringAgreementEntity other = (InsuringAgreementEntity) obj;
    ArrayList<InsuringAgreementItem> lhs = new ArrayList<>(agreementItems);
    ArrayList<InsuringAgreementItem> rhs = new ArrayList<>(other.agreementItems);
    return lhs.equals(rhs);
}


public void setId(Long id){
    this.id = id;
}


public Long getId(){
    return id;
}


}