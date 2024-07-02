package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {
    CharSequence text = new ReversedSequence("abcdef");

    @Test
    void testToString() {
        assertThat(text.toString()).isEqualTo("fedcba");
    }

    @Test
    void testCharAt() {
        assertThat(text.charAt(1)).isEqualTo('e');
    }

    @Test
    void testLength() {
        assertThat(text.length()).isEqualTo(6);
    }

    @Test
    void testSubSequence() {
        assertThat(text.subSequence(1, 4).toString()).isEqualTo("edc");
    }
}
