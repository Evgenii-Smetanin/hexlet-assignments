package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    private String name;
    private Map<String, String> attr;

    public SingleTag(String name, Map<String, String> values) {
        this.name = name;
        this.attr = values;
    }

    public String toString() {
        return "<" + name + parseValues() + ">";
    }
}
// END
