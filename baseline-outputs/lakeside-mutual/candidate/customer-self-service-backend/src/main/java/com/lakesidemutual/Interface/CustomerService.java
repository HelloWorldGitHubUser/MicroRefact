package com.lakesidemutual.Interface;
public interface CustomerService {

   public Optional<CustomerAggregateRoot> updateAddress(CustomerId customerId,Address updatedAddress);
   public Page<CustomerAggregateRoot> getCustomers(String filter,int limit,int offset);
   public CustomerAggregateRoot createCustomer(CustomerProfileEntity customerProfile);
}