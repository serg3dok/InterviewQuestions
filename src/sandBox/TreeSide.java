package sandBox;

import java.util.Random;

/**
 * Created by sergeyo on 4/17/2017.
 */


/*
* Given an unbalanced tree
* Print only nodes that can be visible from the right side
*
 */

class Node {
    Node left;
    Node right;
    Node parent;
    int data;
    Node () {
        this.left = null;
        this.right = null;
        this.data = 0;
    }
    Node (int data) {
        this.data = data;
    }
}



public class TreeSide {
    public static void main(String[] args) {
        Node randomTree = createRandomTree(5);
        printTree(randomTree);

    }

    public static Node generateTree() {


        Node head = new Node(10);
        Node current = head;

        Node tmp = current;
        current = current.left;
        current.parent = tmp;
        current.data = 5;

        tmp = current;
        current = current.left;
        current.parent = tmp;
        current.data = 2;

        tmp = current;
        current = current.left;
        current.parent = tmp;
        current.data = 1;

        current = current.parent;
        current = current.parent;

        tmp = current;
        current = current.right;
        current.parent = tmp;
        current.data = 6;

        current = current.parent;
        current = current.parent;

        tmp = current;
        current = current.right;
        current.parent = tmp;
        current.data = 15;

        return head;
    }

    private static void printTree(Node randomTree) {
        System.out.println(randomTree.data);

        if(randomTree.left != null) {
            System.out.print("left ");
            printTree(randomTree.left);

        }
        if(randomTree.right != null) {
            System.out.print("right ");
            printTree(randomTree.right);
        }

    }

    private static Node createRandomTree(int nodes) {
        Random rnd = new Random();
        Node node = new Node(rnd.nextInt(100));
        Node head = node;

        for (int i = 0; i < nodes; i++) {
            node = head; // point node back to head, start from top
            // 0 - left, 1 - right
            int side = rnd.nextInt(1);

            while ((side == 0 && node.left != null) || (side == 1 && node.right != null)) {
                side = rnd.nextInt(1);
                if (side == 0) {
                    node = node.left;
                }
                else {
                    node = node.right;
                }
            } // if next node == null, insert new node there

            if (side == 0) {
                node.left = new Node(rnd.nextInt(100));
            }
            else {
                node.right = new Node(rnd.nextInt(100));
            }
        }
        return head;
    }
}

