package problems.ch2;

import problems.ch2.util.LinkedList;

public class LinkedListP4<Integer> extends LinkedList<Integer> {
    // Partition linked list

    void partitionSLL(int x) {
        // partitions this linked list around x
        // x may or may not be in the list
        // right partition has elements less than or equal to x
        // ll can have duplicates
        // x can occur anywhere in the right partition

        Node<Integer> head = getHead();

        if(head == null || head.next == null) {
            return;
        }

        Node<Integer> prev = head;
        Node<Integer> curr = head.next;

        while(curr != null) {

            if( (int)curr.data < x) {
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }

        }

        setHead(head);


    }



}
