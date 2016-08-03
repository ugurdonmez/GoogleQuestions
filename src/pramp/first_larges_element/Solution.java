package pramp.first_larges_element;

import java.util.Optional;

/**
 * Created by ugurdonmez on 28/07/16.
 */
public class Solution {

    public static void main(String [] args) {

        Node node30 = new Node(30);
        Node node20 = new Node(20);
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node25 = new Node(25);
        Node node35 = new Node(35);
        Node node45 = new Node(45);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node23 = new Node(23);
        Node node26 = new Node(26);
        Node node34 = new Node(34);
        Node node37 = new Node(37);
        Node node42 = new Node(42);
        Node node50 = new Node(50);

        node30.setLeft(node20);
        node30.setRight(node40);
        node20.setLeft(node10);
        node20.setRight(node25);
        node40.setLeft(node35);
        node40.setRight(node45);
        node10.setLeft(node5);
        node10.setRight(node7);
        node25.setLeft(node23);
        node25.setRight(node26);
        node35.setLeft(node34);
        node35.setRight(node37);
        node45.setLeft(node42);
        node45.setRight(node50);

        getFirstLargesAfterKey(node30, 38).ifPresent(System.out::println);

        getFirstLargesAfterKey(node30, 1).ifPresent(System.out::println);

    }

    public static Optional<Integer> getFirstLargesAfterKey(Node node, int key) {

        Integer prev = null;

        while (node != null) {
            if (node.getValue() < key) {
                prev = node.getValue();
                node = node.getRight().orElse(null);
            } else {
                node = node.getLeft().orElse(null);
            }
        }

        return Optional.ofNullable(prev);
    }

}

class Node {
    private final int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public Optional<Node> getLeft() {
        return Optional.ofNullable(this.left);
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Optional<Node> getRight() {
        return Optional.ofNullable(this.right);
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
