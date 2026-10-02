package org.springframework.samples.petclinic.config;
 import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix = "petclinic")
public class PetclinicProperties {

 private  String database;


public String getDatabase(){
    return database;
}


public void setDatabase(String database){
    this.database = database;
}


}