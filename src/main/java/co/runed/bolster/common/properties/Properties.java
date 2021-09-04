package co.runed.bolster.common.properties;

import java.util.HashMap;
import java.util.Map;

public class Properties {
    private final Map<Property<?>, Object> values = new HashMap<>();

    public Properties() {

    }

    public Properties(Properties properties) {
        this.addAll(properties);
    }

    /**
     * Gets the number of properties
     *
     * @return the number of properties
     */
    public int size() {
        return this.values.size();
    }

    /**
     * Check if empty
     *
     * @return
     */
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    /**
     * Clears all properties
     */
    public void clear() {
        this.values.clear();
    }

    /**
     * Check whether there is a value for a key
     *
     * @param key the key
     * @return
     */
    public boolean contains(Property<?> key) {
        return this.values.containsKey(key);
    }

    /**
     * Gets a property valye
     *
     * @param key the key
     * @return the property value
     */
    public <T> T get(Property<T> key) {
        if (key instanceof FunctionProperty) return ((FunctionProperty<T>) key).getFunction.apply(this);
        if (!this.values.containsKey(key)) return key.getDefault();

        return (T) this.values.get(key);
    }

    /**
     * Sets a property valye
     *
     * @param key   the key
     * @param value the value
     */
    public <T> void set(Property<T> key, T value) {
        if (key instanceof FunctionProperty) {
            ((FunctionProperty<T>) key).setFunction.accept(this, value);
            return;
        }

        this.values.put(key, value);
    }

    public Map<Property<?>, Object> getAll() {
        return new HashMap<>(this.values);
    }

    public void addAll(Properties values) {
        this.values.putAll(values.getAll());
    }

    public void addAll(Map<Property<?>, Object> values) {
        this.values.putAll(values);
    }
}
