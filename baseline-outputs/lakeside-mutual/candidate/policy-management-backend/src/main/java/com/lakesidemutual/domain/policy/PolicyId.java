package com.lakesidemutual.domain.policy;
 import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;
import org.apache.commons.lang3.RandomStringUtils;
import org.microserviceapipatterns.domaindrivendesign.EntityIdentifier;
import org.microserviceapipatterns.domaindrivendesign.ValueObject;
@Embeddable
public class PolicyId implements Serializable,ValueObject,EntityIdentifier<String>{

 private  long serialVersionUID;

 private  String id;

public PolicyId() {
    this.setId(null);
}/**
 * This constructor is needed by ControllerLinkBuilder, see the following
 * spring-hateoas issue for details:
 * https://github.com/spring-projects/spring-hateoas/issues/352
 */
public PolicyId(String id) {
    this.setId(id);
}
public PolicyId random(){
    return new PolicyId(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
}


@Override
public int hashCode(){
    return Objects.hashCode(getId());
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
    PolicyId other = (PolicyId) obj;
    return Objects.equals(getId(), other.getId());
}


public void setId(String id){
    this.id = id;
}


@Override
public String getId(){
    return id;
}


@Override
public String toString(){
    return getId().toString();
}


}