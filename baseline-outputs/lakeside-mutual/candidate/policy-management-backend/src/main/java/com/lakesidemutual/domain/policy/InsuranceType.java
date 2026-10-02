package com.lakesidemutual.domain.policy;
 import java.util.Objects;
import org.microserviceapipatterns.domaindrivendesign.ValueObject;
public class InsuranceType implements ValueObject{

 private  String name;

public InsuranceType() {
    this.name = "";
}public InsuranceType(String name) {
    this.name = name;
}
public String getName(){
    return name;
}


@Override
public int hashCode(){
    return Objects.hash(name);
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
    InsuranceType other = (InsuranceType) obj;
    return Objects.equals(name, other.name);
}


}