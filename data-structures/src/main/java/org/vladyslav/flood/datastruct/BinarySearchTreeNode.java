package org.vladyslav.flood.datastruct;

public class BinarySearchTreeNode<V extends Comparable<V>> extends BinaryTreeNode<BinarySearchTreeNode<V>, V> {

    public BinarySearchTreeNode(V value) {
        super(value);
    }

    public final boolean validate() {
        return validate(null, null);
    }

    protected final boolean validate(V minInclusive, V maxExclusive) {
        V value = getValue();

        if (minInclusive != null && value.compareTo(minInclusive) < 0) {
            return false;
        }

        if (maxExclusive != null && value.compareTo(maxExclusive) >= 0) {
            return false;
        }

        BinarySearchTreeNode<V> leftChild = getChild(BinaryTreeKey.LEFT);
        if (leftChild != null && !leftChild.validate(minInclusive, value)) {
            return false;
        }

        BinarySearchTreeNode<V> rightChild = getChild(BinaryTreeKey.RIGHT);
        if (rightChild != null && !rightChild.validate(value, maxExclusive)) {
            return false;
        }

        return true;
    }

}
