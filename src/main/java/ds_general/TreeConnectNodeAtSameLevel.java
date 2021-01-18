package ds_general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeConnectNodeAtSameLevel {

    static class Node {
        String val;
        Node left;
        Node right;
        Node next;

        Node(String val) {
            this.val = val;
        }

        public String toString() {
            String left_1 = null;
            String right_1 = null;
            String next_1 = null;
            if (left != null)
            left_1 = left.val;
            if (right != null)
            right_1 = right.val;
            if (next != null)
                next_1 = next.val;

            return "Left: "+ left_1+", Right: "+ right_1 +", next  "+ next_1;
        }
    }

    private static void connectNodeAtSameLevel(Node start) {

        Queue<Node> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int size = q.size();
            Node previousNode = null;
            for (int i=0;i<size;i++) {
                Node node = q.poll();
                if(node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (previousNode != null) {
                    node.next = previousNode;
                }
                previousNode = node;
            }

        }
    }

    private static void levelOrderTraversal(Node start) {
        if (start == null) {
            return;
        }
        levelOrderTraversal(start.left);
        System.out.print(start+" ");
        System.out.println();
        levelOrderTraversal(start.right);

    }

    /**
     * Right view.
     *
     * @param root
     * @return
     */
    public static List<String> rightSideView(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<String> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            Boolean isFirstNodeDone = false;
            for (int i=0;i<size;i++) {
                Node node = q.poll();

                if (!isFirstNodeDone) {
                    list.add(node.val);
                    isFirstNodeDone = true;
                }

                if (node.right!= null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
        }


        return list;
    }

    public static void main(String[] args) {
        Node treeNode =new Node("A");
        treeNode.left = new Node("B");
        treeNode.right = new Node("C");
        treeNode.left.left = new Node("D");
        treeNode.left.right = new Node("E");
        treeNode.right.right = new Node("F");
        connectNodeAtSameLevel(treeNode);

        levelOrderTraversal(treeNode);

        rightSideView(treeNode);
    }
}
