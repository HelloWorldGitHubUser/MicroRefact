package com.lakesidemutual.DTO;
 import jakarta.persistence.Embeddable;
import org.apache.commons.lang3.RandomStringUtils;
import org.microserviceapipatterns.domaindrivendesign.EntityIdentifier;
import org.microserviceapipatterns.domaindrivendesign.ValueObject;
import java.io.Serializable;
import java.util.Objects;
public class CustomerId implements Serializable,ValueObject,EntityIdentifier<String>{

 private  long serialVersionUID;

 private  String id;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://4";

public CustomerId() {
    this.setId(null);
}/**
 * This constructor is needed by ControllerLinkBuilder, see the following
 * spring-hateoas issue for details:
 * https://github.com/spring-projects/spring-hateoas/issues/352
 */
public CustomerId(String id) {
    this.setId(id);
}
@Override
public String getId(){
    return id;
}


public CustomerId random(){
    return new CustomerId(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/random"))

;
CustomerId aux = restTemplate.getForObject(builder.toUriString(),CustomerId.class);
return aux;
}


}