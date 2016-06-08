package org.vladyslav.flood.datastruct;

import java.util.EnumMap;
import java.util.Map;

public class BinaryTreeNode<T extends BinaryTreeNode<T, V>, V> implements TreeNode<BinaryTreeKey, T> {

    private final Map<BinaryTreeKey, T> children = new EnumMap<>(BinaryTreeKey.class);
    private final V value;

    public BinaryTreeNode(V value) {
        this.value = value;
    }

    @Override
    public T getChild(BinaryTreeKey childKey) {
        return children.get(childKey);
    }

    @Override
    public void setChild(BinaryTreeKey childKey, T node) {
        children.put(childKey, node);
    }

    public V getValue() {
        return value;
    }

}
