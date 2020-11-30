import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BinaryTree_1 {

    static class Node_1 implements Comparable<Node_1>{

        final long key;
        final long leftNodeIndex;
        final long rightNodeIndex;
        Node_1 left;
        Node_1 right;

        public long getKey() {
            return key;
        }

        public Node_1 getLeft() {
            return left;
        }

        public void setLeft(Node_1 left) {
            this.left = left;
        }

        public Node_1 getRight() {
            return right;
        }

        public void setRight(Node_1 right) {
            this.right = right;
        }

        public long getLeftNodeIndex() {
            return leftNodeIndex;
        }

        public long getRightNodeIndex() {
            return rightNodeIndex;
        }

        public Node_1(long key, int left, int right) {
            this.key = key;
            this.leftNodeIndex = left;
            this.rightNodeIndex = right;
        }

        public int hashCode() {
            return (int) (31 + key + leftNodeIndex + rightNodeIndex);
        }

        public boolean equals(Object object) {
            Node_1 node_1 = (Node_1) object;

            if(this.key == node_1.key) {
                if(this.leftNodeIndex == node_1.leftNodeIndex && this.rightNodeIndex == node_1.rightNodeIndex) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(Node_1 o) {
            if(this.key == o.key) {
                if (this.rightNodeIndex == o.rightNodeIndex && this.leftNodeIndex == o.leftNodeIndex) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
            else {
                if(this.key > o.key) {
                    return 1;
                }
                return -1;
            }
        }

        public String toString() {
            return Long.toString(this.key);
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        long noOfNodes = scanner.nextLong();
        Node_1[] treeNodes = new Node_1[(int) noOfNodes];
        Set<Node_1> keySet = new TreeSet<>();
        for(int i=0;i<noOfNodes;i++) {
            Node_1 node = new Node_1(scanner.nextLong(), scanner.nextInt(), scanner.nextInt());
            keySet.add(node);
            treeNodes[i] = node;
        }
        for(int i=0;i<noOfNodes;i++) {
            Node_1 node = treeNodes[i];
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

        if (treeNodes.length == 0 || inOrderTraversal(treeNodes[0])) {
            System.out.println("CORRECT");
        }
        else {
            System.out.println("INCORRECT");
        }
    }

    private static boolean inOrderTraversal(Node_1 node) {
        Stack<Node_1> nodeStack = new Stack<>();
        Node_1 current = node;

        while (current !=null || nodeStack.size() > 0) {

            while (current != null) {
                if((current.getLeft() != null && ((current.getLeft().getKey() >= current.getKey()) || (current.getLeft().getRight() != null && current.getLeft().getRight().getKey() >= current.getKey()))) ||
                        (current.getRight() != null && (current.getRight().getKey() < current.getKey() ||
                        current.getRight().getLeft() != null && current.getRight().getLeft().getKey() < current.getKey()))){
                    return false;
                }
                nodeStack.push(current);
                current = current.getLeft();
            }

            current = nodeStack.pop();
            current = current.getRight();
        }

        return true;
    }
}
