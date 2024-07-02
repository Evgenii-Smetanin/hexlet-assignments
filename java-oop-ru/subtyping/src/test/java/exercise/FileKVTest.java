package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    KeyValueStorage db;

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
        db = new FileKV(filepath.toString(), Map.of("k1", "v1", "k2", "v2"));
    }

    // BEGIN
    @Test
    void testToMap() {
        assertThat(db.toMap()).isEqualTo(Map.of("k1", "v1", "k2", "v2"));
    }

    @Test
    void testGet() {
        assertThat(db.get("k1", "default")).isEqualTo("v1");
        assertThat(db.get("k3", "default")).isEqualTo("default");
    }

    @Test
    void testSet() {
        db.set("k3", "v3");
        assertThat(db.get("k3", "default")).isEqualTo("v3");
    }

    @Test
    void testUnset() {
        db.unset("k2");
        assertThat(db.get("k2", "default")).isEqualTo("default");
    }

    // END
}
