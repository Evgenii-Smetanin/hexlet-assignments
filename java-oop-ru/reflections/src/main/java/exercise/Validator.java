package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        List<String> invalidFields = new ArrayList<>();

        for (Field field : fields) {
            NotNull notNull = field.getAnnotation(NotNull.class);

            if (notNull != null) {
                try {
                    field.setAccessible(true);

                    if (field.get(address) == null) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return invalidFields;
    }
}
// END
