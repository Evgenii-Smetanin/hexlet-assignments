package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String value;

    public ReversedSequence(String value) {
        this.value = new StringBuilder(value).reverse().toString();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return value.substring(start, end);
    }
}
// END
