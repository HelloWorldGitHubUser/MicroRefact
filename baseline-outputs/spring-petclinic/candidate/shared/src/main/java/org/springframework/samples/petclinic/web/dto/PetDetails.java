package org.springframework.samples.petclinic.web.dto;
 import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
public class PetDetails {

 public  Integer id;

 public  String name;

 public  String owner;

@JsonFormat(pattern = "yyyy-MM-dd")
 public  Date birthDate;

 public  PetTypeDetails type;

 public  List<VisitDetails> visits;

public PetDetails(Integer id, String name, String owner, Date birthDate, PetTypeDetails type, List<VisitDetails> visits) {
    this.id = id;
    this.name = name;
    this.owner = owner;
    this.birthDate = birthDate;
    this.type = type;
    this.visits = visits;
}
}