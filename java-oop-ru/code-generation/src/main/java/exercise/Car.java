package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    public static Car unserialize(String carString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(carString, Car.class);
    }

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
    // END
}
