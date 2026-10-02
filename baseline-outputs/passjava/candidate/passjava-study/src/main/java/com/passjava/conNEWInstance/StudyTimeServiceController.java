package com.passjava.conNEWInstance;
 import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
public class StudyTimeServiceController {

 private StudyTimeService studytimeservice;


@GetMapping
("/getMemberStudyTimeListTest")
public R getMemberStudyTimeListTest(@RequestParam(name = "id") Long id){
  return studytimeservice.getMemberStudyTimeListTest(id);
}


}