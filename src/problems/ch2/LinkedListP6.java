package problems.ch2;

import problems.ch2.util.LinkedList;

public class LinkedListP6<E> {
    // given linked list return whether it is a palindrome

    boolean isPalindrome(LinkedList<E> ll) {

        int len = ll.getLength();
        LinkedList.Node<E> node = ll.getHead();
        Result res = isPalindromeHelper(node, len);
        return res.isMatch;
    }

    class Result {
        LinkedList.Node<E> node;
        boolean isMatch;

        public Result(LinkedList.Node<E> node, boolean isMatch) {
            this.node = node;
            this.isMatch = isMatch;
        }
    }

    Result isPalindromeHelper(LinkedList.Node<E> node, int len) {
        // check if reached mid
        if(len == 1) { // odd number of elements
            return new Result(node.next, true);
        } else if(len == 0) { // even number of elements
            return new Result(node, true);
        } else {
            Result res = isPalindromeHelper(node.next, len-2);
            if(res.isMatch && res.node.data == node.data) {
                res.node = res.node.next;
            } else {
                res.node = null;
                res.isMatch = false;
            }
            return res;
        }
    }

}
