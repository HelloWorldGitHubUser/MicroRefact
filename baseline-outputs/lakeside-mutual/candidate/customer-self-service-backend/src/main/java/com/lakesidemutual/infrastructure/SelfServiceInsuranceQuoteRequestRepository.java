package com.lakesidemutual.infrastructure;
 import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lakesidemutual.domain.customer.CustomerId;
import com.lakesidemutual.domain.selfservice.InsuranceQuoteRequestAggregateRoot;
import org.microserviceapipatterns.domaindrivendesign.Repository;
public interface SelfServiceInsuranceQuoteRequestRepository extends Repository, JpaRepository<InsuranceQuoteRequestAggregateRoot, Long>{


public List<InsuranceQuoteRequestAggregateRoot> findByCustomerInfo_CustomerIdOrderByDateDesc(CustomerId customerId)
;

public List<InsuranceQuoteRequestAggregateRoot> findAllByOrderByDateDesc()
;

}