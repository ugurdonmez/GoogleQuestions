package binary_tree.largest_identical_subtree;

import jdk.nashorn.internal.ir.BinaryNode;

import java.util.Optional;

/**
 * Created by ugurdonmez on 03/08/16.
 */

/*

 google-interview-questions

Given a binary tree, find the largest subtree having at least8 two other duplicate subtrees .

 */

public class Solution {

    public static void main(String [] args) {

        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node4a = new Node(4);
        Node node4b = new Node(4);
        Node node3a = new Node(3);
        Node node3b = new Node(3);
        Node node3c = new Node(3);
        Node node3d = new Node(3);
        Node node1a = new Node(1);
        Node node2a = new Node(2);
        Node node1b = new Node(1);
        Node node2b = new Node(2);

        node6.left = node5;
        node6.right = node7;
        node5.left = node4a;
        node5.right = node4b;
        node4a.left = node3a;
        node4a.right = node3b;
        node4b.left = node3c;
        node4b.right = node3d;
        node3a.left = node1a;
        node3a.right = node2a;
        node3b.left = node1b;
        node3b.right = node2b;

        System.out.println(isEqual(node3a, node3b));

        System.out.println(isEqual(node3c, node3d));

        System.out.println(isEqual(node5, node7));

        getMaxSubtree(node6).ifPresent(System.out::println);
    }

    public static Optional<Result> getMaxSubtree(Node node) {

        if (node == null) {
            return Optional.empty();
        }

        int isEqual = isEqual(node.left, node.right);

        if (isEqual >= 0) {
            return Optional.of(new Result(node, isEqual+1));
        }

        Optional<Result> leftOptional = getMaxSubtree(node.left);
        Optional<Result> rightOptional = getMaxSubtree(node.right);

        if (leftOptional.isPresent() && rightOptional.isPresent()) {
            return leftOptional.get().height > rightOptional.get().height ?
                    leftOptional : rightOptional;
        } else if (leftOptional.isPresent() && !rightOptional.isPresent()) {
            return leftOptional;
        } else if (!leftOptional.isPresent() && rightOptional.isPresent()) {
            return rightOptional;
        } else {
            return Optional.empty();
        }
    }

    /**
     * if node1 == node2 return the height of the tree
     * @param node1
     * @param node2
     * @return
     */
    public static int isEqual(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return 0;
        }

        if (node1 == null && node2 != null) {
            return -1;
        }

        if (node2 == null && node1 != null) {
            return -1;
        }

        if (node1.value != node2.value) {
            return -1;
        }

        int left = isEqual(node1.left, node2.left);
        int right = isEqual(node1.right, node2.right);

        if (left >= 0 && right >= 0) {
            return Integer.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}

class Result {
    Node node;
    int height;

    public Result(Node node, int height) {
        this.node = node;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Result{" +
                "node=" + node.value +
                ", height=" + height +
                '}';
    }
}

class Node {

    final int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
