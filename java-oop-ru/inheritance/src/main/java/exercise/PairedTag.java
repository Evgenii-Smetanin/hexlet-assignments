package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public class PairedTag extends Tag {
    List<Tag> children;
    private String body;

    public PairedTag(String name, Map<String, String> attr, String body, List<Tag> children) {
        super(name, attr);
        this.body = body;
        this.children = children;
    }

    public String toString() {
        return "<" + name + parseValues() + ">" + children.stream().map(Object::toString) + "</" + name + ">";
    }
}
// END
