package ds_general;

import java.util.*;

public class TreeHeight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> nodeToChildMap = new HashMap<>();
        Map<Integer, List<Integer>> nodeToParentMap = new HashMap<>();
        int numberOfNodes = scanner.nextInt();

        for(int i=0;i<numberOfNodes;i++){
            int number = scanner.nextInt();
            nodeToChildMap.put(i, number);

            List<Integer> nodesList = nodeToParentMap.get(number);
            if(nodesList == null){
                nodesList = new ArrayList<>();
                nodesList.add(i);
                nodeToParentMap.put(number, nodesList);
            }
            else {
                nodesList.add(i);
            }
        }

        //System.out.println(nodeToChildMap);
        //System.out.println(nodeToParentMap);

        System.out.println(computeHeight(nodeToParentMap));
        scanner.close();
    }

    private static int computeHeight(Map<Integer, List<Integer>> tree){

        int height = 1;
        List<Integer> nodes = tree.get(-1);
        int parent = nodes.get(0);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.addAll(tree.get(parent));

        while (stack1.size() != 0 || stack2.size() != 0) {

            if (stack1.size() != 0) {
                for (Integer node : stack1) {

                    List<Integer> connectedNodesList = tree.get(node);
                    if(connectedNodesList != null)
                    stack2.addAll(tree.get(node));
                }
                stack1.clear();
            } else {
                for (Integer node : stack2) {
                    List<Integer> connectedNodesList = tree.get(node);
                    if(connectedNodesList != null)
                    stack1.addAll(tree.get(node));
                }
                stack2.clear();
            }
            height++;
        }
        return height;
    }
}
