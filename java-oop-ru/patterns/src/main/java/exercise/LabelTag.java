package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface childTag;
    private String type;

    public LabelTag(String type, TagInterface childTag) {
        this.childTag = childTag;
        this.type = type;
    }

    @Override
    public String render() {
        return "<label>" + type + childTag.render() + "</label>";
    }
}
// END
