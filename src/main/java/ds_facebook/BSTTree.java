package ds_facebook;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tree {
    private final int value;

    private Tree leftNode;
    private Tree rightNode;

    public int getValue() {
        return value;
    }

    public Tree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Tree leftNode) {
        this.leftNode = leftNode;
    }

    public Tree getRightNode() {
        return rightNode;
    }

    public void setRightNode(Tree rightNode) {
        this.rightNode = rightNode;
    }

    Tree(int value, Tree leftNode, Tree rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }


}

public class BSTTree {

    private static void addNodeToTree(Tree nodeToAdd, Tree start) {
        Tree traverse = start;

        while (true) {
            if(traverse.getValue() < nodeToAdd.getValue()) {
                Tree node = traverse.getRightNode();
                if(node == null) {
                    traverse.setRightNode(nodeToAdd);
                    break;
                }
                traverse = node;
            }
            else if(traverse.getValue() >= nodeToAdd.getValue()) {
                Tree node = traverse.getLeftNode();
                if (node == null) {
                    traverse.setLeftNode(nodeToAdd);
                    break;
                }
                traverse = node;
            }
        }
    }

    private static void inOrderTraversal(Tree start) {

        if(start == null) {
            return;
        }
        inOrderTraversal(start.getLeftNode());
        System.out.print(start.getValue()+" ");
        inOrderTraversal(start.getRightNode());

    }

    private static int visibleNode(Tree start) {
        List<Tree> evenLevel = new ArrayList<>();
        List<Tree> oddLevel = new ArrayList<>();
        evenLevel.add(start);
        int count = 0;
        while (true) {
            if(evenLevel.size() > 0) {
                for(Tree tree : evenLevel) {
                    if(tree.getLeftNode() != null) {
                        oddLevel.add(tree.getLeftNode());
                    }
                    if (tree.getRightNode() != null) {
                        oddLevel.add(tree.getRightNode());
                    }
                }
                if(oddLevel.size() == 0) {
                    count++;
                    break;
                }
                else {
                    count++;
                }
                evenLevel.clear();
            }

            if(oddLevel.size() > 0) {
                for(Tree tree : oddLevel) {
                    if(tree.getLeftNode() != null) {
                        evenLevel.add(tree.getLeftNode());
                    }
                    if (tree.getRightNode() != null) {
                        evenLevel.add(tree.getRightNode());
                    }
                }
                if(evenLevel.size() == 0) {
                    count++;
                    break;
                }
                else {
                    count++;
                }
                oddLevel.clear();
            }
        }
        System.out.println();
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfNode = scanner.nextInt();
        Tree start = null;

        for (int i=0;i<numberOfNode;i++) {
            Tree node = new Tree(scanner.nextInt(), null, null);

            if(start == null) {
                start = node;
                continue;
            }
            addNodeToTree(node, start);
        }
        //In Order traversal
        inOrderTraversal(start);
        visibleNode(start);
    }
}
