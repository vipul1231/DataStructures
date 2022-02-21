/*
package ds_facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

*/
/**
 * Average at each level.
 *//*

public class BinaryTree {

    public static void main(String[] args) {

        Tree node = new Tree(20);

        node.leftNode = new Tree(4);
        node.rightNode = new Tree(19);
        node.leftNode.leftNode = new Tree(17);
        node.leftNode.rightNode = new Tree(18);
        node.rightNode.leftNode =new Tree(45);
        node.rightNode.rightNode = new Tree(5);

        LinkedList<Tree> linkedList = new LinkedList<>();
        linkedList.add(node);
        List<Integer> result = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            int count = linkedList.size();
            int sum = 0;
            for (int i=0;i<count;i++) {
                Tree tree = linkedList.poll();
                assert tree != null;
                if(tree.leftNode != null)
                linkedList.add(tree.leftNode);
                if (tree.rightNode != null)
                linkedList.add(tree.rightNode);
                sum += tree.getValue();
            }
            result.add(sum/count);
        }
        System.out.println(result);
    }
}
*/
