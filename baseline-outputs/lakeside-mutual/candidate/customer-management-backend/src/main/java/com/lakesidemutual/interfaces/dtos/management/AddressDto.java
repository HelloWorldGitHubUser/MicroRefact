package com.lakesidemutual.interfaces.dtos.management;
 public class AddressDto {

 private  String streetAddress;

 private  String postalCode;

 private  String city;

public AddressDto() {
}
public void setStreetAddress(String streetAddress){
    this.streetAddress = streetAddress;
}


public void setCity(String city){
    this.city = city;
}


public String getPostalCode(){
    return postalCode;
}


public void setPostalCode(String postalCode){
    this.postalCode = postalCode;
}


public String getStreetAddress(){
    return streetAddress;
}


public String getCity(){
    return city;
}


}