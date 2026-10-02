package com.lakesidemutual.infrastructure;
 import java.util.List;
import org.microserviceapipatterns.domaindrivendesign.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.domain.policy.PolicyAggregateRoot;
import com.lakesidemutual.domain.policy.PolicyId;
public interface PolicyRepository extends Repository, JpaRepository<PolicyAggregateRoot, PolicyId>{


public PolicyId nextId(){
    return PolicyId.random();
}
;

public List<PolicyAggregateRoot> findAllByCustomerIdOrderByCreationDateDesc(CustomerId customerId)
;

}