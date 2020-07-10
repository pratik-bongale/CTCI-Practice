package problems.ch2;

import problems.ch2.util.LinkedList;

public class LinkedListP2<E> extends LinkedList<E> {

    E findKthToLastElement(LinkedList<E> ll, int k) {

        // reverse array
        LinkedList.Node<E> curr = ll.getHead();
        LinkedList.Node<E> prev = null;
        Node<E> temp;
        while( curr  != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // navigate the reversed array k steps
        curr = prev;
        while( curr != null && k > 0 ) {
            curr = curr.next;
            k--;
        }

        if( curr == null ) {
            return null;
        } else {
            return curr.data;
        }

    }

    // CTCI uses a recursive solution maintaining a counter to which each callback adds 1
    // when ctr == k you return that node
    // CTCI iterative solution uses two pointers and places them k nodes apart..
    // when runner reaches null, slow ptr is at kth-to-last node

}
