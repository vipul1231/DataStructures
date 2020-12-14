package ds_facebook;

import java.util.Scanner;

/**
 *
 */
class Tree {

    private final int value;

    private final Tree node;

    public int getValue() {
        return value;
    }

    public Tree getNode() {
        return node;
    }

    Tree(int value, Tree node) {
        this.value = value;
        this.node = node;
    }
}


public class BinaryTree {
    static Tree start = null;
    public static void addNodesToTree(Tree tree1) {

        Tree traversal = tree1;
        Tree startCopy = start;
        while (startCopy.getNode() != null) {
            startCopy = startCopy.getNode();
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = scanner.nextInt();
        for(int i=0;i<nodes;i++) {
            Tree tree1 = new Tree(scanner.nextInt(), null);
            addNodesToTree(tree1);
            if(start == null) {
                start = tree1;
            }

        }
        scanner.close();
    }
}
