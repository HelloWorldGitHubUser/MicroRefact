package com.lakesidemutual.interfaces.dtos.policy.customer;
 public class CustomerIdDto {

 private  String id;

public CustomerIdDto() {
}/**
 * This constructor is needed by ControllerLinkBuilder, see the following
 * spring-hateoas issue for details:
 * https://github.com/spring-projects/spring-hateoas/issues/352
 */
public CustomerIdDto(String id) {
    this.id = id;
}
public void setId(String id){
    this.id = id;
}


public String getId(){
    return this.id;
}


@Override
public String toString(){
    return id;
}


}