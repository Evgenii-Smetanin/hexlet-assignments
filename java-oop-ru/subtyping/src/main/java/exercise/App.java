package exercise;

import java.util.Map.Entry;

// BEGIN
public class App {
    public static final void swapKeyValue(KeyValueStorage db) {
        for (Entry e : db.toMap().entrySet()) {
            db.unset((String) e.getKey());
            db.set((String) e.getValue(), (String) e.getKey());
        }
    }
}
// END
