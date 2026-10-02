package com.lakesidemutual.domain.identityaccess;
 import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.lakesidemutual.domain.customer.CustomerId;
@Entity
@Table(name = "user_logins")
public class UserLoginEntity {

@Id
@GeneratedValue
 private  Long id;

 private  String authorities;

 private  String email;

 private  String password;

@Embedded
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "customerId")) })
 private  CustomerId customerId;

public UserLoginEntity() {
}public UserLoginEntity(String email, String password, String authorities, CustomerId customerId) {
    this.email = email;
    this.password = password;
    this.authorities = authorities;
    this.customerId = customerId;
}
public void setPassword(String password){
    this.password = password;
}


public String getPassword(){
    return password;
}


public void setEmail(String email){
    this.email = email;
}


public void setAuthorities(String authorities){
    this.authorities = authorities;
}


public String getEmail(){
    return email;
}


public void setId(Long id){
    this.id = id;
}


public Long getId(){
    return id;
}


public void setCustomerId(CustomerId customerId){
    this.customerId = customerId;
}


public String getAuthorities(){
    return authorities;
}


public CustomerId getCustomerId(){
    return customerId;
}


}