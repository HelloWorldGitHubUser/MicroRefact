package com.passjava.conInterface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.passjava.conInterface.StudyTimeService;
public class StudyTimeServiceImpl implements StudyTimeService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://5";


public R getMemberStudyTimeListTest(Long id){
  UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url.concat("/getMemberStudyTimeListTest"))
    .queryParam("id",id)
;  R aux = restTemplate.getForObject(builder.toUriString(), R.class);

 return aux;
}


}