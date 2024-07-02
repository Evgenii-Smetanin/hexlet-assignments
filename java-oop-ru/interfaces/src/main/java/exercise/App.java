package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int num) {
        return apartments.stream().sorted().limit(num).map(Object::toString).collect(Collectors.toList());
    }
}
// END
