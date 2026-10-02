package com.lakesidemutual.interfaces.dtos.city;
 import java.util.List;
public class CitiesResponseDto {

 private  List<String> cities;

public CitiesResponseDto(List<String> cities) {
    this.cities = cities;
}
public List<String> getCities(){
    return cities;
}


}