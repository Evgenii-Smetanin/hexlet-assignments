package exercise;

import java.util.Map;

// BEGIN
public class Tag {
    protected String name;
    protected Map<String, String> attr;

    public Tag() {
    }

    public Tag(String name, Map<String, String> values) {
        this.name = name;
        this.attr = values;
    }

    protected String parseValues() {
        StringBuilder sb = new StringBuilder();

        attr.forEach((k, v) -> {
            sb.append(" ");
            sb.append(k);
            sb.append("=\"");
            sb.append(v);
            sb.append("\"");
        });

        return sb.toString();
    }
}
// END
