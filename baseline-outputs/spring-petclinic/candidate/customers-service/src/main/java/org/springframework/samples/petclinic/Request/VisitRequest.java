package org.springframework.samples.petclinic.Request;
import org.springframework.samples.petclinic.DTO.Visit;
public interface VisitRequest {

   public Set<Visit> getVisitsInternal(Integer id);
   public void setVisitsInternal(Set<Visit> visits,Integer id);
   public void addVisit(Visit visit,Integer id);
}