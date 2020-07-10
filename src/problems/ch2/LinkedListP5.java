package problems.ch2;

import problems.ch2.util.LinkedList;
import problems.ch2.util.LinkedList.Node;

public class LinkedListP5 {
    // given two linked lists containing digits of a and b, return a+b
    // Part 1:
    // numbers are given in reversed order a = 356 is given as 6->5->3
    // you need to return the answer in reversed order as well
    // Part 2:
    // follow up with a solution when numbers are not in reverse order

    LinkedList<Integer> addLL(LinkedList<Integer> a, LinkedList<Integer> b) {

        int d1, d2, d3, sum, c = 0;

        Node<Integer> num1 = a.getHead();
        Node<Integer> num2 = b.getHead();

        LinkedList<Integer> resLL = new LinkedList<>();

        while(num1 != null || num2 != null || c != 0) {
            d1 = num1 == null ? 0 : num1.data;
            d2 = num2 == null ? 0 : num2.data;

            sum = d1 + d2 + c;
            d3 = sum % 10;
            c = sum / 10;
            resLL.add(d3);

            num1 = num1 != null ? num1.next : null;
            num2 = num2 != null ? num2.next : null;
        }

        return resLL;
    }

    LinkedList<Integer> addLLRecursive(LinkedList<Integer> a, LinkedList<Integer> b) {

        Node<Integer> resHead = addLLRecursiveHelper(a.getHead(), b.getHead(), 0);
        LinkedList<Integer> resLL = new LinkedList<>();
        resLL.setHead(resHead);
        return resLL;

    }

    Node<Integer> addLLRecursiveHelper( Node<Integer> node1, Node<Integer> node2, int carry ) {
        if( node1 == null && node2 == null && carry == 0) {
            return null;
        }

        int value = carry;

        if( node1 != null ) {
            value += node1.data;
            node1 = node1.next;
        }

        if( node2 != null ) {
            value += node2.data;
            node2 = node2.next;
        }

        carry = value / 10;

        Node<Integer> newNode = new Node<>(value % 10);
        newNode.setNext( addLLRecursiveHelper(node1, node2, carry) );

        return newNode;
    }

    LinkedList<Integer> addLLNonReversedRecursive(LinkedList<Integer> a, LinkedList<Integer> b) {
        Node<Integer> node1 = a.getHead();
        Node<Integer> node2 = b.getHead();
        Node<Integer> zeroNode;

        while(node1 != null || node2 != null ) {
            if(node1 == null) {
                zeroNode = new Node<>(0, a.getHead());
                a.setHead(zeroNode);
                node2 = node2.next;
            } else if(node2 == null) {
                zeroNode = new Node<>(0, b.getHead());
                b.setHead(zeroNode);
                node1 = node1.next;
            } else {
                node1 = node1.next;
                node2 = node2.next;
            }
        }


        int[] carry = new int[] {0};
        Node<Integer> resHead = addLLNonReversedRecursiveHelper(a.getHead(), b.getHead(), carry);

        LinkedList<Integer> resLL = new LinkedList<>();
        if( carry[0] == 0 ) {
            resLL.setHead(resHead);
        } else {
            resLL.setHead(new Node<>(carry[0], resHead));
        }

        return resLL;
    }

    Node<Integer> addLLNonReversedRecursiveHelper(Node<Integer> node1, Node<Integer> node2, int[] carry) {
        // assumes both lists are of same length
        if(node1 == null && node2 == null) {
            return null;
        }

        Node<Integer> newNode = new Node<>(0);
        if(node1 != null && node2 != null) {
                Node<Integer> nextNode = addLLNonReversedRecursiveHelper(node1.next, node2.next, carry);
                int value = node1.data + node2.data + carry[0];
                carry[0] = value / 10;         // as arrays are passed by reference (you can also create a class Carry)
                newNode.setData(value % 10);
                newNode.setNext(nextNode);
        } else {
            throw new NullPointerException("Cannot add two lists of different lengths");
        }

        return newNode;
    }


}
