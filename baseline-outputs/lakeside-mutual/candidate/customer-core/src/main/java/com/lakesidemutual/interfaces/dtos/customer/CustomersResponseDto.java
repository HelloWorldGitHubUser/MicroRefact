package com.lakesidemutual.interfaces.dtos.customer;
 import java.util.List;
import org.springframework.hateoas.RepresentationModel;
public class CustomersResponseDto extends RepresentationModel{

 private  List<CustomerResponseDto> customers;

public CustomersResponseDto(List<CustomerResponseDto> customers) {
    this.customers = customers;
}
public List<CustomerResponseDto> getCustomers(){
    return customers;
}


}