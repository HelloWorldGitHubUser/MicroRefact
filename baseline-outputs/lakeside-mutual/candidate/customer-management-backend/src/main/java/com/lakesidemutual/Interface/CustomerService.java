package com.lakesidemutual.Interface;
public interface CustomerService {

   public Page<CustomerAggregateRoot> getCustomers(String filter,int limit,int offset);
   public Optional<CustomerAggregateRoot> updateCustomerProfile(CustomerId customerId,CustomerProfileEntity updatedCustomerProfile);
}