package problems.ch2;

import problems.ch2.util.LinkedList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LinkedListP1<E> extends LinkedList<E> {

    void removeDuplicates(LinkedList<E> ll) {
        Set<E> visitedSet = new HashSet<>();
        Node<E> curr = ll.getHead();
        Node<E> prev = null;
        while( curr != null ) {
            if( visitedSet.contains(curr.data) ) {
                prev.next = curr.next;
            } else {
                visitedSet.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public void removeDuplicatesNoExtraMemory(LinkedList<E> ll) {

        Node<E> head = ll.getHead();
        if(head == null) {
            return;
        }

        Node<E> ptr1 = head;
        Node<E> ptr2;
        Node<E> prev;

        while(ptr1 != null) {
            ptr2 = ptr1.next;
            prev = ptr1;
            while(ptr2 != null) {
                if(ptr1.data.equals(ptr2.data)) {
                    prev.next = ptr2.next;
                } else {
                    prev = ptr2;
                }
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }
}
