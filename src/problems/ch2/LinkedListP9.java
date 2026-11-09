package problems.ch2;

import problems.ch2.util.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LinkedListP9<E> {
    // this is from the extra problems list
    // given a binary tree, output depth-wise list of nodes

    List<List<E>> getDepthWiseListFromBinaryTree(BinaryTree.Node<E> root) {
        // use a modification of pre-order traversal / use BFS approach
        // pre-order: ROOT-LEFT-RIGHT

        List<List<E>> res = new ArrayList<>();
        preOrderAndFill(root, res, 0);
        return res;
    }

    void preOrderAndFill(BinaryTree.Node<E> root, List<List<E>> res, int depth) {
        if(root != null) {
            if(res.size() == depth) {
                // create new level
                res.add(new ArrayList<E>());
            }
            res.get(depth).add(root.data);
            preOrderAndFill(root.left, res, depth+1);
            preOrderAndFill(root.right, res, depth+1);
        }
    }

}
