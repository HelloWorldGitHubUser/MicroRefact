package com.lakesidemutual.domain.customer;
 import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.microserviceapipatterns.domaindrivendesign.DomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
@Component
public class CityLookupService implements DomainService{

 private  String CSV_FILE;

 private  char CSV_SEPARATOR;

 private  String POSTAL_CODE_KEY;

 private  String CITY_KEY;

 private  Multimap<String,String> lookupMap;

 private  Logger logger;


public Multimap<String,String> getLookupMap(){
    if (lookupMap == null) {
        lookupMap = loadLookupMap();
        logger.info("Loaded " + lookupMap.size() + " postal-code / city pairs.");
    }
    return lookupMap;
}


public Multimap<String,String> loadLookupMap(){
    Multimap<String, String> map = TreeMultimap.create();
    try (InputStream file = new ClassPathResource(CSV_FILE).getInputStream()) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(CSV_SEPARATOR);
        MappingIterator<Map<String, String>> readValues = mapper.readerFor(Map.class).with(schema).readValues(file);
        List<Map<String, String>> values = readValues.readAll();
        for (Map<String, String> value : values) {
            String postalCode = value.get(POSTAL_CODE_KEY).trim();
            String city = value.get(CITY_KEY).trim();
            if (city == null || postalCode == null) {
                continue;
            }
            map.put(postalCode, city);
        }
    } catch (IOException e) {
        logger.error("Failed to create city lookup-map.", e);
    }
    return map;
}


public List<String> getCitiesForPostalCode(String postalCode){
    Multimap<String, String> lookupMap = getLookupMap();
    return new ArrayList<>(lookupMap.get(postalCode));
}


}