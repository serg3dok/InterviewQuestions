package sandBox;

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
    int data;
    Node () {
        this.left = null;
        this.right = null;
        this.data = 0;
    }
    Node (Node left, Node right, int data) {
        if (left != null) this.left = left;
        else this.left = null;

        if (right != null) this.right = left;
        else this.right = null;
    }
}

public class TreeSide {
    public static void main(String[] args) {
        Node randomTree = createRandomTree();

    }

    private static Node createRandomTree() {

        return null;
    }


}
