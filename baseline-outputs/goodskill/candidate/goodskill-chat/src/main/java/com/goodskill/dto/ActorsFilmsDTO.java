package com.goodskill.dto;
 import java.util.List;
public class ActorsFilmsDTO {

 private  String actor;

 private  List<String> movies;

public ActorsFilmsDTO() {
}
public void setActor(String actor){
    this.actor = actor;
}


public List<String> getMovies(){
    return movies;
}


public void setMovies(List<String> movies){
    this.movies = movies;
}


@Override
public String toString(){
    return "ActorsFilmsDTO{" + "actor='" + actor + '\'' + ", movies=" + movies + '}';
}


public String getActor(){
    return actor;
}


}