package com.passjava.conInterface;
 import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import com.passjava.conInterface.SearchService;
public class SearchServiceImpl implements SearchService{

@Autowired
 private RestTemplate restTemplate;

  String url = "http://4";


}