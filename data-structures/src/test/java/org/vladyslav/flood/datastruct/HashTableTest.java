package org.vladyslav.flood.datastruct;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testFunctionality() {
        HashTable<HashCode, String> hashTable = new HashTable<>(3);
        String message = "Empty hashtable should return null on get";
        assertNull(message, hashTable.get(new HashCode(0)));
        assertNull(message, hashTable.get(new HashCode(1)));
        assertNull(message, hashTable.get(new HashCode(-1)));
        assertNull(message, hashTable.get(new HashCode(11)));
        assertNull(message, hashTable.get(new HashCode(Integer.MAX_VALUE)));
        assertNull(message, hashTable.get(new HashCode(Integer.MIN_VALUE)));

        message = "Empty hashtable should return null on remove";
        assertNull(message, hashTable.remove(new HashCode(0)));
        assertNull(message, hashTable.remove(new HashCode(1)));
        assertNull(message, hashTable.remove(new HashCode(-2)));
        assertNull(message, hashTable.remove(new HashCode(21)));
        assertNull(message, hashTable.remove(new HashCode(Integer.MAX_VALUE)));
        assertNull(message, hashTable.remove(new HashCode(Integer.MIN_VALUE)));

        assertNull("Empty hashtable should return null on put", hashTable.put(new HashCode(0), "Zero"));
        assertEquals("Get should return previously put element", "Zero", hashTable.get(new HashCode(0)));

        message = "Hashtable with single element should return null on get for other hashcode";
        assertNull(message, hashTable.get(new HashCode(1)));
        assertNull(message, hashTable.get(new HashCode(2)));
        assertNull(message, hashTable.get(new HashCode(3)));
        assertNull(message, hashTable.get(new HashCode(3)));

        assertNull("Should return null for non-equal key with same hashcode", hashTable.get(new HashCode(0, 1)));

        hashTable.put(new HashCode(0, 1), "Zero'");
        assertEquals("Zero", hashTable.get(new HashCode(0)));
        assertEquals("Zero'", hashTable.get(new HashCode(0, 1)));

        hashTable.put(new HashCode(0), "0");
        assertEquals("0", hashTable.get(new HashCode(0)));
        assertEquals("Zero'", hashTable.get(new HashCode(0, 1)));

        hashTable.put(new HashCode(0, 1), "0.1");
        assertEquals("0", hashTable.get(new HashCode(0)));
        assertEquals("0.1", hashTable.get(new HashCode(0, 1)));

        String oldValue = hashTable.remove(new HashCode(0));
        assertEquals("0", oldValue);
        assertNull(hashTable.get(new HashCode(0)));
        assertEquals("0.1", hashTable.get(new HashCode(0, 1)));

        oldValue = hashTable.remove(new HashCode(0, 1));
        assertEquals("0.1", oldValue);
        assertNull(hashTable.get(new HashCode(0, 1)));

        hashTable.put(new HashCode(Integer.MIN_VALUE), "MIN_VALUE");
        hashTable.put(new HashCode(Integer.MAX_VALUE), "MAX_VALUE");
        hashTable.put(new HashCode(5), "Five");

        assertEquals("MIN_VALUE", hashTable.get(new HashCode(Integer.MIN_VALUE)));
        assertEquals("MAX_VALUE", hashTable.get(new HashCode(Integer.MAX_VALUE)));
        assertEquals("Five", hashTable.get(new HashCode(5)));

        assertEquals("MIN_VALUE", hashTable.remove(new HashCode(Integer.MIN_VALUE)));
        assertEquals("MAX_VALUE", hashTable.remove(new HashCode(Integer.MAX_VALUE)));
        assertEquals("Five", hashTable.remove(new HashCode(5)));

        assertNull(hashTable.get(new HashCode(Integer.MIN_VALUE)));
        assertNull(hashTable.get(new HashCode(Integer.MAX_VALUE)));
        assertNull(hashTable.get(new HashCode(5)));

        hashTable.put(new HashCode(5), "New Five");
        assertEquals("New Five", hashTable.remove(new HashCode(5)));
    }

    private static final class HashCode {
        private final int hashCode;
        private final int id;

        private HashCode(int hashCode) {
            this(hashCode, 0);
        }

        private HashCode(int hashCode, int id) {
            this.hashCode = hashCode;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HashCode hashCode1 = (HashCode) o;

            if (hashCode != hashCode1.hashCode) return false;
            return id == hashCode1.id;

        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }

}