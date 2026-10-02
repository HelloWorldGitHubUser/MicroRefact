package com.lakesidemutual.infrastructure;
 import org.springframework.data.jpa.repository.JpaRepository;
import com.lakesidemutual.domain.customer.CustomerAggregateRoot;
import com.lakesidemutual.domain.customer.CustomerId;
import org.microserviceapipatterns.domaindrivendesign.Repository;
import com.lakesidemutual.DTO.CustomerId;
public interface CustomerRepository extends JpaRepository<CustomerAggregateRoot, CustomerId>, Repository{


public CustomerId nextId(){
    return CustomerId.random();
}
;

}