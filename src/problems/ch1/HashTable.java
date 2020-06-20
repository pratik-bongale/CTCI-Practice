package problems.ch1;

import problems.ch1.exceptions.KeyNotFoundException;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTable<E> {
    // assuming that keys are always strings, value is of type E
    // hash collision resolved by chaining
    // references:
    // https://stackoverflow.com/questions/27654229/how-to-properly-define-an-array-of-linked-list-in-java

    private static final int capacity = 10;
    @SuppressWarnings("unchecked") LinkedList<HashItem>[] hashTable = new LinkedList[capacity];

    E get(String key) throws KeyNotFoundException {
        // get the hashcode from key
        int hashCode = getHashCode(key);

        // compute index from hashcode
        int index = hashCode % capacity;

        // search the linked list on that index
        E res = null;
        if ( hashTable[index] != null ) {
            LinkedList<HashItem> ll = hashTable[index];
            for (HashItem item : ll) {
                if( item.getKey().equals(key) ) {
                    res = item.getValue();
                    break;
                }
            }
        }

        if (res == null)
            throw new KeyNotFoundException("Key not found in Hash Table");
        else
            return res;
    }

    void put(String key, E value) {
        // get the hashcode
        int hashCode = getHashCode(key);

        // compute index
        int index = hashCode % capacity;

        // check to see if an item with the same key exists
        // OR
        // put HashItem at the end of linked list

        if ( hashTable[index] != null ) {
            for (Iterator<HashItem> iter = hashTable[index].iterator(); iter.hasNext(); ) {
                HashItem existingItem = iter.next();
                if( existingItem.getKey().equals(key) ) {
                    // if it already exists, replace the value
                    existingItem.setValue(value);
                    break;
                }
            }
        } else {
            hashTable[index] = new LinkedList<>();
            HashItem item = new HashItem(key, value);
            hashTable[index].addLast(item);
        }
    }

    boolean contains(String key) {
        boolean res = false;

        // get the hashcode
        int hashCode = getHashCode(key);

        // compute index
        int index = hashCode % capacity;

        // check to see if an item with the same key exists
        if ( hashTable[index] != null) {

            for (Iterator<HashItem> iter = hashTable[index].iterator(); iter.hasNext(); ) {
                HashItem existingItem = iter.next();
                if( existingItem.getKey().equals(key) ) {
                    res = true;
                    break;
                }
            }

        }

        return res;
    }

    private int getHashCode(String key) {
        return Math.abs(key.hashCode());
    }

    private class HashItem {
        String key;
        E value;

        public HashItem(String key, E value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }

}
