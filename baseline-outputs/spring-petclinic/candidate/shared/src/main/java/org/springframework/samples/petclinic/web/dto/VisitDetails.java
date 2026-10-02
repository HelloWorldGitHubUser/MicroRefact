package org.springframework.samples.petclinic.web.dto;
 import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
public class VisitDetails {

 public  Integer id;

 public  Integer petId;

@JsonFormat(pattern = "yyyy-MM-dd")
 public  Date date;

 public  String description;

public VisitDetails(Integer id, Integer petId, Date date, String description) {
    this.id = id;
    this.petId = petId;
    this.date = date;
    this.description = description;
}
}