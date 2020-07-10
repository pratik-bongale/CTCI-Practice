package problems.ch2.util;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<E> {

    Node<E> head;
    Node<E> tail;

    public Node<E> getNodeAtIndex(int indexOfNode) {
        Node<E> curr = head;
        int i = 0;
        while(curr != null) {
            if(i == indexOfNode) break;
            curr = curr.next;
            i++;
        }
        return curr;
    }

    public static class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public void add(E n) {
        Node<E> newNode = new Node<>(n, null);
        if(head == null || tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void add(Node<E> newNode) {
        if(head == null || tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }


    public void addAllFromList(java.util.List<E> ll) {
        for(E ele : ll) {
            this.add(ele);
        }
    }

    public void addAllFromArray(E[] arr) {
        for(E ele : arr) {
            this.add(ele);
        }
    }

    public int getLength() {
        Node<E> h = getHead();
        int len = 0;
        while(h != null) {
            len++;
            h = h.next;
        }
        return len;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> newHead) {
        this.head = newHead;
        // set tail
        Node<E> curr = newHead;
        while(curr.next != null)
            curr = curr.next;
        this.tail = curr;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public List<E> toList() {
        List<E> res = new ArrayList<>();

        Node<E> curr = getHead();
        while(curr != null) {
            res.add(curr.data);
            curr = curr.next;
        }

        return res;
    }
}
