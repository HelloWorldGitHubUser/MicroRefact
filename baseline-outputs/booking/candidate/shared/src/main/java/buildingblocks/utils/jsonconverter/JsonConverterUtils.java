package buildingblocks.utils.jsonconverter;
 import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
public class JsonConverterUtils {

 private  ObjectMapper objectMapper;

private JsonConverterUtils() {
    throw new AssertionError("Cannot instantiate utility class.");
}
public String serializeObject(Object object){
    try {
        return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException ex) {
        throw new RuntimeException("Serialization error", ex);
    }
}


public T deserialize(byte[] bytes,Class<T> type){
    try {
        return objectMapper.readValue(bytes, type);
    } catch (IOException ex) {
        throw new RuntimeException("Deserialization error", ex);
    }
}


}