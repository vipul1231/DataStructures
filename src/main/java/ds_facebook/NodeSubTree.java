package ds_facebook;


import java.util.ArrayList;
import java.util.List;

class TreeNode {

    // Tree Node
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int u;
        char c;

        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }
}


public class NodeSubTree {

    private static TreeNode.Node searchTheNode(TreeNode.Node root, int nodeValue) {
        List<TreeNode.Node> evenLevel = new ArrayList<>();
        List<TreeNode.Node> oddLevel = new ArrayList<>();
        evenLevel.add(root);
        while (oddLevel.size() != 0 || evenLevel.size() != 0) {

            if (evenLevel.size() > 0) {
                for (TreeNode.Node node : evenLevel) {
                    if (node.val == nodeValue)
                        return node;
                    else {
                        oddLevel.addAll(node.children);
                    }
                }
                evenLevel.clear();
            } else {
                for (TreeNode.Node node : oddLevel) {
                    if (node.val == nodeValue)
                        return node;
                    else {
                        evenLevel.addAll(node.children);
                    }
                }
                evenLevel.clear();
            }
        }
        return null;
    }

    static int returnCount(TreeNode.Node root, char charToSearch, String[] array) {
        List<TreeNode.Node> evenLevel = new ArrayList<>();
        List<TreeNode.Node> oddLevel = new ArrayList<>();
        evenLevel.add(root);
        int count = 0;
        while (oddLevel.size() != 0 || evenLevel.size() != 0) {
            if(evenLevel.size() > 0) {
                for(TreeNode.Node node : evenLevel) {
                    if(array[node.val-1].equals(String.valueOf(charToSearch))) {
                        count++;
                    }
                    oddLevel.addAll(node.children);
                }
                evenLevel.clear();
            }
            else {
                for(TreeNode.Node node : oddLevel) {
                    if(array[node.val-1].equals(String.valueOf(charToSearch))) {
                        count++;
                    }
                    evenLevel.addAll(node.children);
                }
                oddLevel.clear();
            }
        }

        return count;
    }

    static int[] countOfNodes(TreeNode.Node root, ArrayList<TreeNode.Query> queries, String s) {
        // Write your code here
        String[] stringSplit = s.split("");

        int count = queries.size();
        int[] result = new int[count];
        int start = 0;
        while (start != count) {
            TreeNode.Query query = queries.get(start);
            int nodeValueToSearch = query.u;
            char charValueToSearch = query.c;
            TreeNode.Node node = searchTheNode(root, nodeValueToSearch);
            result[start] = returnCount(node,charValueToSearch,stringSplit);
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n_2 = 7, q_2 = 3;
        String s_2 = "abaacab";
        TreeNode.Node root_2 = new TreeNode.Node(1);
        root_2.children.add(new TreeNode.Node(2));
        root_2.children.add(new TreeNode.Node(3));
        root_2.children.add(new TreeNode.Node(7));
        root_2.children.get(0).children.add(new TreeNode.Node(4));
        root_2.children.get(0).children.add(new TreeNode.Node(5));
        root_2.children.get(1).children.add(new TreeNode.Node(6));
        ArrayList<TreeNode.Query> queries_2 = new ArrayList<>();
        queries_2.add(new TreeNode.Query(1, 'a'));
        queries_2.add(new TreeNode.Query(2, 'b'));
        queries_2.add(new TreeNode.Query(3, 'a'));
        int[] output_2 = countOfNodes(root_2, queries_2, s_2);
        for(Integer result : output_2) {
            System.out.print(result+" ");
        }
    }
}
