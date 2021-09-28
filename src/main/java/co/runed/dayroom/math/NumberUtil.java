package co.runed.dayroom.math;

import java.lang.reflect.Field;
import java.util.Map;

public class NumberUtil {
    public static Number addNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        }
        else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        }
        else if (a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        }
        else {
            return a.intValue() + b.intValue();
        }
    }

    public static Number subtractNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() - b.doubleValue();
        }
        else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() - b.floatValue();
        }
        else if (a instanceof Long || b instanceof Long) {
            return a.longValue() - b.longValue();
        }
        else {
            return a.intValue() - b.intValue();
        }
    }

    public static Number multiplyNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() * b.doubleValue();
        }
        else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() * b.floatValue();
        }
        else if (a instanceof Long || b instanceof Long) {
            return a.longValue() * b.longValue();
        }
        else {
            return a.intValue() * b.intValue();
        }
    }

    public static Number divideNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() / b.doubleValue();
        }
        else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() / b.floatValue();
        }
        else if (a instanceof Long || b instanceof Long) {
            return a.longValue() / b.longValue();
        }
        else {
            return a.intValue() / b.intValue();
        }
    }

    /* FROM https://stackoverflow.com/questions/60257300/how-to-set-a-number-field-with-a-different-number-type-using-java-reflection */
    public static final Map<Class<?>, Setter> SETTERS = Map.copyOf(Map.<Class<?>, NumericSetter>ofEntries(
            Map.entry(byte.class, (field, bean, n) -> field.setByte(bean, n.byteValue())),
            Map.entry(short.class, (field, bean, n) -> field.setShort(bean, n.shortValue())),
            Map.entry(int.class, (field, bean, n) -> field.setInt(bean, n.intValue())),
            Map.entry(long.class, (field, bean, n) -> field.setLong(bean, n.longValue())),
            Map.entry(float.class, (field, bean, n) -> field.setFloat(bean, n.floatValue())),
            Map.entry(double.class, (field, bean, n) -> field.setDouble(bean, n.doubleValue())),
            Map.entry(Byte.class, (field, bean, n) -> field.set(bean, n.byteValue())),
            Map.entry(Short.class, (field, bean, n) -> field.set(bean, n.shortValue())),
            Map.entry(Integer.class, (field, bean, n) -> field.set(bean, n.intValue())),
            Map.entry(Long.class, (field, bean, n) -> field.set(bean, n.longValue())),
            Map.entry(Float.class, (field, bean, n) -> field.set(bean, n.floatValue())),
            Map.entry(Double.class, (field, bean, n) -> field.set(bean, n.doubleValue()))
    ));

    public interface Setter {
        void set(Field field, Object bean, Object value) throws IllegalAccessException;

        Setter FALLBACK = Field::set;
    }

    interface NumericSetter extends Setter {
        @Override
        default void set(Field field, Object bean, Object value)
                throws IllegalAccessException {
            setNumeric(field, bean, (Number) value);
        }

        void setNumeric(Field f, Object bean, Number n) throws IllegalAccessException;
    }
}
