package exercise;

import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private final String path;
    private final Map<String, String> data;

    FileKV(String path, Map<String, String> data) {
        this.path = path;
        this.data = data;
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> m = Utils.unserialize(Utils.readFile(path));
        m.put(key, value);
        Utils.writeFile(path, Utils.serialize(m));
    }

    @Override
    public void unset(String key) {
        Map<String, String> m = Utils.unserialize(Utils.readFile(path));
        m.remove(key);
        Utils.writeFile(path, Utils.serialize(m));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> m = Utils.unserialize(Utils.readFile(path));
        return m.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(path));
    }
}
// END
