package org.springframework.samples.petclinic.web.dto;
 import java.util.List;
public class OwnerDetails {

 public  Integer id;

 public  String firstName;

 public  String lastName;

 public  String address;

 public  String city;

 public  String telephone;

 public  List<PetDetails> pets;

public OwnerDetails(Integer id, String firstName, String lastName, String address, String city, String telephone, List<PetDetails> pets) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.telephone = telephone;
    this.pets = pets;
}
}