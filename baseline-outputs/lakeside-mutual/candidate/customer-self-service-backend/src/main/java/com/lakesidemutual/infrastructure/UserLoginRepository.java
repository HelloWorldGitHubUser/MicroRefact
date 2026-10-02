package com.lakesidemutual.infrastructure;
 import org.springframework.data.jpa.repository.JpaRepository;
import com.lakesidemutual.domain.identityaccess.UserLoginEntity;
import org.microserviceapipatterns.domaindrivendesign.Repository;
public interface UserLoginRepository extends Repository, JpaRepository<UserLoginEntity, Long>{


public UserLoginEntity findByEmail(String email)
;

}