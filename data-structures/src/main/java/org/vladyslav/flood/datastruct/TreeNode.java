package org.vladyslav.flood.datastruct;

public interface TreeNode<K, T extends TreeNode<K, T>> {

    T getChild(K childKey);

    void setChild(K childKey, T node);

}
