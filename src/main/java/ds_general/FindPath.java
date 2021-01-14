package ds_general;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    private static boolean isSumFound = false;


    public static boolean hasPathSum(TreeNode root, int sum) {

        //leaf node
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }

        sum = sum - root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }

    static List<List<Integer>> combination = new ArrayList<>();
    public static void pathSum(TreeNode root, int sum, List<Integer> combos) {

        if (root == null) {
            return;
        }

        if (root.left ==null && root.right == null){
            //combos.remove(combos.size() -1);
            if (sum - root.val == 0) {
                combos.add(root.val);
                combination.add(new ArrayList<>(combos));
                combos.remove(combos.size()-1);
            }

            return;
        }

        combos.add(root.val);
        pathSum(root.left, sum - root.val, combos);
        pathSum(root.right, sum-root.val, combos);
        combos.remove(combos.size()-1);
    }



    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new ArrayList<>());
        return combination;
    }

    /**
     *
     *       5
     *      / \
     *     4   8
     *    /   / \
     *   11  13  4
     *  /  \      \
     * 7    2      1
     *
     *
     * @param args
     */


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);

        System.out.println(hasPathSum(root, 22));

        System.out.println(pathSum(root, 22));
    }
}
