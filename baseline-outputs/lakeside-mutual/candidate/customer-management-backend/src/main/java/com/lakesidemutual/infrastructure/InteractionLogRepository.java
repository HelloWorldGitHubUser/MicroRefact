package com.lakesidemutual.infrastructure;
 import org.springframework.data.jpa.repository.JpaRepository;
import com.lakesidemutual.domain.interactionlog.InteractionLogAggregateRoot;
import org.microserviceapipatterns.domaindrivendesign.Repository;
public interface InteractionLogRepository extends Repository, JpaRepository<InteractionLogAggregateRoot, String>{


}