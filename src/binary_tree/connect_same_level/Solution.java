package binary_tree.connect_same_level;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ugurdonmez on 03/11/16.
 */
public class Solution {

    public static void main(String [] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.left = node2;
        node1.right = node3;

        connect(node1);
    }

    public static void connect(Node root) {
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        boolean level = true;
        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (level) {
                while (!queue1.isEmpty()) {
                    Node node = queue1.poll();

                    if (!queue1.isEmpty()) {
                        node.nextRight = queue1.peek();
                    }

                    if (node.left != null) {
                        queue2.add(node.left);
                    }

                    if (node.right != null) {
                        queue2.add(node.right);
                    }
                }
                level = false;
            } else {
                while (!queue2.isEmpty()) {
                    Node node = queue2.poll();

                    if (!queue2.isEmpty()) {
                        node.nextRight = queue2.peek();
                    }

                    if (node.left != null) {
                        queue1.add(node.left);
                    }

                    if (node.right != null) {
                        queue1.add(node.right);
                    }
                }
                level = true;
            }
        }
    }
}

class Node {
    int data;
    Node left, right, nextRight;

    Node(int item) {
        data = item;
        left = right = nextRight = null;
    }
}
