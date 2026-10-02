package com.lakesidemutual.infrastructure;
 import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.microserviceapipatterns.domaindrivendesign.Repository;
import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.domain.policy.InsuranceQuoteRequestAggregateRoot;
public interface PolicyInsuranceQuoteRequestRepository extends Repository, JpaRepository<InsuranceQuoteRequestAggregateRoot, Long>{


public List<InsuranceQuoteRequestAggregateRoot> findAllByOrderByDateDesc()
;

public List<InsuranceQuoteRequestAggregateRoot> findByCustomerInfo_CustomerId(CustomerId customerId)
;

}