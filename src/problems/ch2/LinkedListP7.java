package problems.ch2;

import problems.ch2.util.LinkedList;

public class LinkedListP7<E> {
    // given two SLL, see if they intersect

    public boolean hasIntersection(LinkedList<E> ll1, LinkedList<E> ll2) {
        // traverse both and keep count, if you reach end of 1 list, get diff of counts and reset counters accordingly

        LinkedList.Node<E> ptrLL1 = ll1.getHead();
        LinkedList.Node<E> ptrLL2 = ll2.getHead();

        // traverse until one of them reaches its end
        while(ptrLL1 != null && ptrLL2 != null) {
            ptrLL1 = ptrLL1.next;
            ptrLL2 = ptrLL2.next;
        }

        // move the other linked list to ensure both have same number of remaining elements
        LinkedList.Node<E> temp;
        if(ptrLL1 == null) {
            temp = ll2.getHead();
            while(ptrLL2 != null) {
                temp = temp.next;
                ptrLL2 = ptrLL2.next;
            }
            ptrLL2 = temp;
            ptrLL1 = ll1.getHead();
        } else { // ptrLL2 == null
            temp = ll1.getHead();
            while(ptrLL1 != null) {
                temp = temp.next;
                ptrLL1 = ptrLL1.next;
            }
            ptrLL1 = temp;
            ptrLL2 = ll2.getHead();
        }

        // check intersection
        while(ptrLL1 != null && ptrLL2 != null){
            if(ptrLL1 == ptrLL2)
                return true;
            ptrLL1 = ptrLL1.next;
            ptrLL2 = ptrLL2.next;
        }

        return false;
    }
}
