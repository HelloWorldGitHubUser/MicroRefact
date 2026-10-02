package com.lakesidemutual.NEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class CustomerServiceController {

 private CustomerService customerservice;


@GetMapping
("/getCustomers")
public Page<CustomerAggregateRoot> getCustomers(@RequestParam(name = "filter") String filter,@RequestParam(name = "limit") int limit,@RequestParam(name = "offset") int offset){
  return customerservice.getCustomers(filter,limit,offset);
}


@GetMapping
("/updateCustomerProfile")
public Optional<CustomerAggregateRoot> updateCustomerProfile(@RequestParam(name = "customerId") CustomerId customerId,@RequestParam(name = "updatedCustomerProfile") CustomerProfileEntity updatedCustomerProfile){
  return customerservice.updateCustomerProfile(customerId,updatedCustomerProfile);
}


@GetMapping
("/updateAddress")
public Optional<CustomerAggregateRoot> updateAddress(@RequestParam(name = "customerId") CustomerId customerId,@RequestParam(name = "updatedAddress") Address updatedAddress){
  return customerservice.updateAddress(customerId,updatedAddress);
}


@GetMapping
("/createCustomer")
public CustomerAggregateRoot createCustomer(@RequestParam(name = "customerProfile") CustomerProfileEntity customerProfile){
  return customerservice.createCustomer(customerProfile);
}


}