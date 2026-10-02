package com.lakesidemutual.interfaces.dtos.policy.customer;
 import java.util.List;
import org.springframework.hateoas.RepresentationModel;
public class PaginatedCustomerResponseDto extends RepresentationModel{

 private  String filter;

 private  int limit;

 private  int offset;

 private  int size;

 private  List<CustomerDto> customers;

public PaginatedCustomerResponseDto() {
}public PaginatedCustomerResponseDto(String filter, int limit, int offset, int size, List<CustomerDto> customers) {
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


public void setSize(int size){
    this.size = size;
}


public List<CustomerDto> getCustomers(){
    return customers;
}


public int getLimit(){
    return limit;
}


public void setLimit(int limit){
    this.limit = limit;
}


public void setOffset(int offset){
    this.offset = offset;
}


public int getOffset(){
    return offset;
}


public void setCustomers(List<CustomerDto> customers){
    this.customers = customers;
}


public void setFilter(String filter){
    this.filter = filter;
}


}