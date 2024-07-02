package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attr) {
        super(name, attr);
    }

    public String toString() {
        return "<" + name + parseValues() + ">";
    }
}
// END
