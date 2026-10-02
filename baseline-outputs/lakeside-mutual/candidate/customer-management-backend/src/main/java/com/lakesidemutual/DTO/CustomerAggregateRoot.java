package com.lakesidemutual.DTO;
 import io.github.adr.embedded.MADR;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.microserviceapipatterns.domaindrivendesign.RootEntity;
public class CustomerAggregateRoot implements RootEntity{

 private  CustomerId id;

 private  CustomerProfileEntity customerProfile;

public CustomerAggregateRoot() {
}public CustomerAggregateRoot(CustomerId id, CustomerProfileEntity customerProfile) {
    this.id = id;
    this.customerProfile = customerProfile;
}
@MADR(value = 1, title = "Data transfer between interface layer and domain layer", contextAndProblem = "Need to pass information from the interfaces layer to the domain layer without introducing a layering violation", alternatives = { "Pass existing domain objects", "Pass the DTOs directly", "Pass the components of the DTO", "Add a new value type in the domain layer and use it as parameter object" }, chosenAlternative = "Pass existing domain objects", justification = "This solution doesn't introduce a layering violation and it is simple because it doesn't require any additional classes.")
public void moveToAddress(Address address){
    customerProfile.moveToAddress(address);
}


public CustomerProfileEntity getCustomerProfile(){
    return customerProfile;
}


public CustomerId getId(){
    return id;
}


}