package org.vladyslav.flood.datastruct;

public class KeyValuePair<K, V> {

    private final K key;
    private V value;

    public KeyValuePair(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
