package ds_facebook;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tree_1 {
    private final int value;

    private Tree_1 leftNode;
    private Tree_1 rightNode;

    public int getValue() {
        return value;
    }

    public Tree_1 getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Tree_1 leftNode) {
        this.leftNode = leftNode;
    }

    public Tree_1 getRightNode() {
        return rightNode;
    }

    public void setRightNode(Tree_1 rightNode) {
        this.rightNode = rightNode;
    }

    Tree_1(int value, Tree_1 leftNode, Tree_1 rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }


}

public class BSTTree {

    private static void addNodeToTree(Tree_1 nodeToAdd, Tree_1 start) {
        Tree_1 traverse = start;

        while (true) {
            if(traverse.getValue() < nodeToAdd.getValue()) {
                Tree_1 node = traverse.getRightNode();
                if(node == null) {
                    traverse.setRightNode(nodeToAdd);
                    break;
                }
                traverse = node;
            }
            else if(traverse.getValue() >= nodeToAdd.getValue()) {
                Tree_1 node = traverse.getLeftNode();
                if (node == null) {
                    traverse.setLeftNode(nodeToAdd);
                    break;
                }
                traverse = node;
            }
        }
    }

    private static void inOrderTraversal(Tree_1 start) {

        if(start == null) {
            return;
        }
        inOrderTraversal(start.getLeftNode());
        System.out.print(start.getValue()+" ");
        inOrderTraversal(start.getRightNode());

    }

    private static int visibleNode(Tree_1 start) {
        List<Tree_1> evenLevel = new ArrayList<>();
        List<Tree_1> oddLevel = new ArrayList<>();
        evenLevel.add(start);
        int count = 0;
        while (true) {
            if(evenLevel.size() > 0) {
                for(Tree_1 tree1 : evenLevel) {
                    if(tree1.getLeftNode() != null) {
                        oddLevel.add(tree1.getLeftNode());
                    }
                    if (tree1.getRightNode() != null) {
                        oddLevel.add(tree1.getRightNode());
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
                for(Tree_1 tree1 : oddLevel) {
                    if(tree1.getLeftNode() != null) {
                        evenLevel.add(tree1.getLeftNode());
                    }
                    if (tree1.getRightNode() != null) {
                        evenLevel.add(tree1.getRightNode());
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
        Tree_1 start = null;

        for (int i=0;i<numberOfNode;i++) {
            Tree_1 node = new Tree_1(scanner.nextInt(), null, null);

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
