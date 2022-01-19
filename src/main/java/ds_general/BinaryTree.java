package ds_general;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

    static class Node {

        final long key;
        final long leftNodeIndex;
        final long rightNodeIndex;
        Node left;
        Node right;

        public long getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public long getLeftNodeIndex() {
            return leftNodeIndex;
        }

        public long getRightNodeIndex() {
            return rightNodeIndex;
        }

        public Node(int key, int left, int right) {
            this.key = key;
            this.leftNodeIndex = left;
            this.rightNodeIndex = right;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long noOfNodes = scanner.nextLong();
        Node[] treeNodes = new Node[(int) noOfNodes];
        for(int i=0;i<noOfNodes;i++) {
            Node node = new Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            treeNodes[i] = node;
        }
        for(int i=0;i<noOfNodes;i++) {
            Node node = treeNodes[i];
            long leftIndex = node.getLeftNodeIndex();
            if (leftIndex == -1){
                node.setLeft(null);
            }
            else {
                node.setLeft(treeNodes[(int) node.getLeftNodeIndex()]);
            }
            long rightIndex = node.getRightNodeIndex();
            if (rightIndex == -1) {
                node.setRight(null);
            }
            else {
                node.setRight(treeNodes[(int) node.getRightNodeIndex()]);
            }
        }

        inOrderTraversal(treeNodes[0]);
        System.out.println();
        preOrder(treeNodes[0]);
        System.out.println();
        postOrder(treeNodes[0]);
        scanner.close();
    }

    private static void inOrderTraversal(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = node;

        while (current !=null || nodeStack.size() > 0) {

            while (current != null) {
                nodeStack.push(current);
                current = current.getLeft();
            }

            current = nodeStack.pop();
            System.out.print(current.key+" ");
            current = current.getRight();
        }
    }

    private static void preOrder(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()) {
            Node node1 = nodeStack.peek();
            System.out.print(node1.key+" ");
            nodeStack.pop();

            if (node1.right != null) {
                nodeStack.push(node1.right);
            }
            if (node1.left != null) {
                nodeStack.push(node1.left);
            }
        }
    }

    private static void postOrder(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);
        Node dummyNode = null;
        while (!stack1.isEmpty()) {
            dummyNode = stack1.peek();
            stack1.pop();
            stack2.push(dummyNode);

            if(dummyNode.left != null) {
                stack1.push(dummyNode.left);
            }
            if (dummyNode.right != null) {
                stack1.push(dummyNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            dummyNode = stack2.pop();
            System.out.print(dummyNode.key+" ");
        }
    }
}
