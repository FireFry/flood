package org.vladyslav.flood.datastruct;

public class DoublyLinkedNode<E> {

    private E value;
    private DoublyLinkedNode<E> previous;
    private DoublyLinkedNode<E> next;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public DoublyLinkedNode<E> getPrevious() {
        return previous;
    }

    public DoublyLinkedNode<E> getNext() {
        return next;
    }

    public void detachPrevious() {
        if (previous != null) {
            previous.next = null;
            previous = null;
        }
    }

    public void detachNext() {
        if (next != null) {
            next.previous = null;
            next = null;
        }
    }

    public void attachPrevious(DoublyLinkedNode<E> other) {
        detachPrevious();
        if (other != null) {
            other.detachNext();
            previous = other;
            other.next = this;
        }
    }

    public void attachNext(DoublyLinkedNode<E> other) {
        detachNext();
        if (other != null) {
            other.detachPrevious();
            next = other;
            other.previous = this;
        }
    }

    public void insertPrevious(E value) {
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>();
        newNode.setValue(value);
        newNode.attachPrevious(previous);
        newNode.attachNext(this);
    }

    public void insertNext(E value) {
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>();
        newNode.setValue(value);
        newNode.attachNext(next);
        newNode.attachPrevious(this);
    }

    public void remove() {
        if (previous != null) {
            previous.next = next;
        }
        if (next != null) {
            next.previous = previous;
        }
        previous = null;
        next = null;
    }

}
