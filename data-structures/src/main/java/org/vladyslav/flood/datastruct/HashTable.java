package org.vladyslav.flood.datastruct;

public class HashTable<K, V> {

    private final GenericArray<DoublyLinkedNode<KeyValuePair<K, V>>> table;

    public HashTable(int size) {
        table = new GenericArray<>(size);
    }

    public V put(K key, V value) {
        DoublyLinkedNode<KeyValuePair<K, V>> node = getEntitiesList(key);
        while (node.getNext() != null && !node.getNext().getValue().getKey().equals(key)) {
            node = node.getNext();
        }
        KeyValuePair<K, V> keyValuePair;
        V oldValue = null;
        if (node.getNext() != null) {
            keyValuePair = node.getNext().getValue();
            oldValue = keyValuePair.getValue();
        } else {
            keyValuePair = new KeyValuePair<>(key);
            node.insertNext(keyValuePair);
        }
        keyValuePair.setValue(value);
        return oldValue;
    }

    public V get(K key) {
        DoublyLinkedNode<KeyValuePair<K, V>> node = getEntitiesList(key).getNext();
        while (node != null && !node.getValue().getKey().equals(key)) {
            node = node.getNext();
        }
        if (node == null) {
            return null;
        }
        KeyValuePair<K, V> keyValuePair = node.getValue();
        return keyValuePair.getValue();
    }

    public V remove(K key) {
        DoublyLinkedNode<KeyValuePair<K, V>> node = getEntitiesList(key).getNext();
        while (node != null && !node.getValue().getKey().equals(key)) {
            node = node.getNext();
        }
        if (node == null) {
            return null;
        }
        node.remove();
        KeyValuePair<K, V> keyValuePair = node.getValue();
        return keyValuePair.getValue();
    }

    private DoublyLinkedNode<KeyValuePair<K, V>> getEntitiesList(K key) {
        int tableIndex = Math.floorMod(key.hashCode(), table.size());
        DoublyLinkedNode<KeyValuePair<K, V>> result = table.get(tableIndex);
        if (result == null) {
            result = new DoublyLinkedNode<>();
            table.set(tableIndex, result);
        }
        return result;
    }

}
