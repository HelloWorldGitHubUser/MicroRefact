package com.lakesidemutual.DTO;
 import com.lakesidemutual.domain.policy.Address;
public class AddressDto {

 private  String streetAddress;

 private  String postalCode;

 private  String city;

 private RestTemplate restTemplate = new RestTemplate();

  String url = "http://3";

public AddressDto() {
}public AddressDto(String streetAddress, String postalCode, String city) {
    this.streetAddress = streetAddress;
    this.postalCode = postalCode;
    this.city = city;
}
public String getPostalCode(){
    return postalCode;
}


public String getStreetAddress(){
    return streetAddress;
}


public String getCity(){
    return city;
}


public void setStreetAddress(String streetAddress){
    this.streetAddress = streetAddress;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setStreetAddress"))

.queryParam("streetAddress",streetAddress)
;
restTemplate.put(builder.toUriString(),null);
}


public void setPostalCode(String postalCode){
    this.postalCode = postalCode;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setPostalCode"))

.queryParam("postalCode",postalCode)
;
restTemplate.put(builder.toUriString(),null);
}


public void setCity(String city){
    this.city = city;
 

  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/setCity"))

.queryParam("city",city)
;
restTemplate.put(builder.toUriString(),null);
}


}