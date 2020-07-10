package problems.ch2;

import problems.ch2.util.LinkedList;

public class LinkedListP3<E> extends LinkedList<E> {

    // delete middle node
    void deleteNode(Node<E> node) {
        // Time: O(N)
        // Space: O(1)

        Node<E> prev = node;
        Node<E> curr = node.next;

//        prev.data = curr.data;
        while(curr.next != null) {
            prev.data = curr.data;
            prev = curr;
            curr = curr.next;
        }

        // get rid of the last node
        prev.data = curr.data;
        prev.next = null;
    }


}
