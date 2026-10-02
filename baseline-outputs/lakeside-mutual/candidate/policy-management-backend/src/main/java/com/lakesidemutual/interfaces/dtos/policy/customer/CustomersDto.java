package com.lakesidemutual.interfaces.dtos.policy.customer;
 import java.util.List;
import org.springframework.hateoas.RepresentationModel;
public class CustomersDto extends RepresentationModel{

 private  List<CustomerDto> customers;

public CustomersDto() {
}public CustomersDto(List<CustomerDto> customers) {
    this.customers = customers;
}
public List<CustomerDto> getCustomers(){
    return customers;
}


public void setCustomers(List<CustomerDto> customers){
    this.customers = customers;
}


}