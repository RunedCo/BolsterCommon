package co.runed.dayroom.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtil {
    public static List<Method> getMethodsAnnotatedWith(final Class<?> type, final Class<? extends Annotation> annotation) {
        final List<Method> methods = new ArrayList<>();
        var clazz = type;
        while (clazz != Object.class) { // need to iterated thought hierarchy in order to retrieve methods from above the current instance
            // iterate though the list of methods declared in the class represented by klass variable, and add those annotated with the specified annotation
            for (final var method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotation)) {
                    var annotInstance = method.getAnnotation(annotation);
                    methods.add(method);
                }
            }
            // move to the upper class in the hierarchy in search for more methods
            clazz = clazz.getSuperclass();
        }

        return methods;
    }

    public static <T extends Annotation> Map<Field, T> getFieldsAnnotatedWith(final Class<?> type, final Class<T> annotation) {
        final Map<Field, T> fields = new HashMap<>();
        var clazz = type;
        while (clazz != Object.class) { // need to iterated thought hierarchy in order to retrieve methods from above the current instance
            // iterate though the list of methods declared in the class represented by klass variable, and add those annotated with the specified annotation
            for (final var field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(annotation)) {
                    var annotInstance = field.getAnnotation(annotation);
                    fields.put(field, annotInstance);
                }
            }
            // move to the upper class in the hierarchy in search for more methods
            clazz = clazz.getSuperclass();
        }

        return fields;
    }
}
