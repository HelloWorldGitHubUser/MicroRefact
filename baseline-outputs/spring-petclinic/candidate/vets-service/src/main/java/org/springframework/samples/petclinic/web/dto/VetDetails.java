package org.springframework.samples.petclinic.web.dto;
 import java.util.List;
public class VetDetails {

 public  Integer id;

 public  String firstName;

 public  String lastName;

 public  List<SpecialtyDetails> specialties;

public VetDetails(Integer id, String firstName, String lastName, List<SpecialtyDetails> specialties) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.specialties = specialties;
}
}