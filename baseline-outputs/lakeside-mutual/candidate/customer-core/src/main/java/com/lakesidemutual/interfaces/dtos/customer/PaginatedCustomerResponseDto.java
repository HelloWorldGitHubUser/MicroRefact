package com.lakesidemutual.interfaces.dtos.customer;
 import java.util.List;
import org.springframework.hateoas.RepresentationModel;
public class PaginatedCustomerResponseDto extends RepresentationModel{

 private  String filter;

 private  int limit;

 private  int offset;

 private  int size;

 private  List<CustomerResponseDto> customers;

public PaginatedCustomerResponseDto(String filter, int limit, int offset, int size, List<CustomerResponseDto> customers) {
    this.filter = filter;
    this.limit = limit;
    this.offset = offset;
    this.size = size;
    this.customers = customers;
}
public String getFilter(){
    return filter;
}


public int getSize(){
    return size;
}


public List<CustomerResponseDto> getCustomers(){
    return customers;
}


public int getLimit(){
    return limit;
}


public int getOffset(){
    return offset;
}


}