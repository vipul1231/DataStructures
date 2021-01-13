package ds_general;

import java.util.*;

public class LargestValue {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> maxList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for (int i=0;i<size;i++) {
                TreeNode treeNode = q.poll();
                max = Math.max(max, treeNode.val);
                if (treeNode.left != null) q.add(treeNode.left);
                if (treeNode.right != null) q.add(treeNode.right);
            }
            maxList.add(max);
        }
        return maxList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, null);
        treeNode.left = new TreeNode(3, null,null);
        treeNode.right = new TreeNode(2, null, null);
        treeNode.left.left = new TreeNode(5, null, null);
        treeNode.left.right = new TreeNode(3, null, null);

        treeNode.right.right = new TreeNode(9, null, null);
        System.out.println(largestValues(treeNode));
    }
}
