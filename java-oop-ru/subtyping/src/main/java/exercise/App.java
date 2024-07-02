package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static final void swapKeyValue(KeyValueStorage db) {
        for (Entry e: db.toMap().entrySet()) {
            db.unset((String) e.getKey());
            db.set((String) e.getValue(), (String) e.getKey());
        }
    }
}
// END
