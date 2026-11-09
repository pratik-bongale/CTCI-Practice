package problems.ch2.util;

import java.util.List;

public class BinaryTree<E> {

    Node<E> root;

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public static class Node<E> {
        public E data;
        public Node<E> left;
        public Node<E> right;

        public Node(E data) {
            this.data = data;
        }

    }

    Node<E> getRoot() {
        return this.root;
    }


}
