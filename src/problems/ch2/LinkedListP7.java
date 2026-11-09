package problems.ch2;

import problems.ch2.util.LinkedList;
import problems.ch2.util.LinkedList.Node;

public class LinkedListP7<E> {
    // given two SLL, see if they intersect

    public boolean hasIntersection(LinkedList<E> ll1, LinkedList<E> ll2) {
        // traverse both and keep count, if you reach end of 1 list, get diff of counts and reset counters accordingly

        LinkedList.Node<E> ptrLL1 = ll1.getHead();
        LinkedList.Node<E> ptrLL2 = ll2.getHead();

        // get lengths for each list
        Result res1 = getTailAndSize(ptrLL1);
        Result res2 = getTailAndSize(ptrLL2);

        if(res1.tail != res2.tail)
            return false;

        Node<E> shorter = res1.size < res2.size ? ll1.getHead() : ll2.getHead();
        Node<E> longer = res2.size > res1.size ? ll2.getHead() : ll1.getHead();
        int diff = Math.abs(res1.size - res2.size);
        longer = forwardPtr(longer, diff);

        while(shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter != null;
    }

    private Node<E> forwardPtr(Node<E> longer, int diff) {
        while(diff > 0 && longer != null) {
            longer = longer.next;
            diff--;
        }

        return longer;
    }

    private Result getTailAndSize(Node<E> ptrLL) {
        if(ptrLL == null)
            return null;

        int size = 0;
        while(ptrLL.next != null) {
            ptrLL = ptrLL.next;
            size++;
        }

        return new Result(ptrLL, size);
    }

    class Result {
        Node<E> tail;
        int size;

        public Result(Node<E> tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
}
