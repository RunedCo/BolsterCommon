package co.runed.dayroom.gson;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GsonUtil {
    private static List<Function<GsonBuilder, GsonBuilder>> gsonBuilderFuncs = new ArrayList<>();

    public static void addBuilderFunction(Function<GsonBuilder, GsonBuilder> function) {
        gsonBuilderFuncs.add(function);
    }

    public static Gson create() {
        ExclusionStrategy excludeStrategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }

            @Override
            public boolean shouldSkipField(FieldAttributes field) {
                return field.getAnnotation(JsonExclude.class) != null;
            }
        };

        GsonBuilder builder = new GsonBuilder()
                .setLenient()
                .setExclusionStrategies(excludeStrategy)
                .registerTypeAdapter(ZonedDateTime.class, new TypeAdapter<ZonedDateTime>() {
                    @Override
                    public void write(JsonWriter out, ZonedDateTime value) throws IOException {
                        out.value(value == null ? null : value.toString());
                    }

                    @Override
                    public ZonedDateTime read(JsonReader in) throws IOException {
                        return ZonedDateTime.parse(in.nextString());
                    }
                })
                .enableComplexMapKeySerialization();

        for (var func : gsonBuilderFuncs) {
            builder = func.apply(builder);
        }

        return builder.create();
    }
}
