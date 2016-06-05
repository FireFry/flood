package org.vladyslav.flood.datastruct;

public class GenericArray<E> {

    private final Object[] objects;

    public GenericArray(int size) {
        objects = new Object[size];
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) objects[index];
    }

    public void set(int index, E value) {
        objects[index] = value;
    }

    public int size() {
        return objects.length;
    }

}
