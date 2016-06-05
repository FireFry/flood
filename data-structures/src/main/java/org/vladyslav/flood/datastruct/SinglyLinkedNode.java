package org.vladyslav.flood.datastruct;

public class SinglyLinkedNode<E> {

    private E value;
    private SinglyLinkedNode<E> next;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public SinglyLinkedNode<E> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedNode<E> next) {
        this.next = next;
    }

}
