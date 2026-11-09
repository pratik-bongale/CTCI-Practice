package problems.ch2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import problems.ch2.util.BinaryTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListP9Test {

    @Test
    void GetDepthWiseListFromBinaryTree() {
        LinkedListP9<Integer> testObj = new LinkedListP9<>();
        BinaryTree.Node<Integer> root = new BinaryTree.Node<>(1);
        root.left = new BinaryTree.Node<>(2);
        root.right = new BinaryTree.Node<>(3);
        root.left.left = new BinaryTree.Node<>(4);
        root.right.left = new BinaryTree.Node<>(7);
        root.right.right = new BinaryTree.Node<>(8);
        root.right.left.left = new BinaryTree.Node<>(10);

        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(2,3),
                Arrays.asList(4,7,8),
                Collections.singletonList(10)
        );

        assertEquals(expected, testObj.getDepthWiseListFromBinaryTree(root));



    }
}