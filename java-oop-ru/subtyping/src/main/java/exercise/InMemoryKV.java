package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> values;

    public InMemoryKV(Map<String, String> values) {
        this.values = new HashMap<>(values);
    }

    @Override
    public void set(String key, String value) {
        values.put(key, value);
    }

    @Override
    public void unset(String key) {
        values.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return values.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(values);
    }
}
// END
