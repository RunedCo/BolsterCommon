package co.runed.dayroom.properties;

import co.runed.dayroom.util.Describable;
import co.runed.dayroom.util.Identifiable;

/**
 * A property passed to an ability when cast
 */
public class Property<T> implements Identifiable, Describable {
    private String id;
    private T defaultValue;

    public Property(String id) {
        this(id, null);
    }

    public Property(String id, T defaultValue) {
        this.id = id;
        this.defaultValue = defaultValue;
    }

    public String toString() {
        return "<Property " + this.id + ">";
    }

    public Property<T> setDefault(T defaultValue) {
        this.defaultValue = defaultValue;

        return this;
    }

    public T getDefault() {
        return this.defaultValue;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getDescription() {
        return null;
    }
}