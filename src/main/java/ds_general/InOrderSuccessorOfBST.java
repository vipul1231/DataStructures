package ds_general;

import java.util.Stack;

class Node {

    int value;
    Node leftTree;
    Node rightTree;

    public Node(int value) {
        this.value = value;
    }
}


public class InOrderSuccessorOfBST {


    private static void inOrderSuccessor(Node node, int value) {
        Node successor = null;
        while (true) {

            if (node.value == value) {

                if (node.rightTree != null) {
                    node = node.rightTree;
                    while (node.leftTree != null)  {
                        node = node.leftTree;
                    }
                    System.out.println(node.value);
                }
                else {
                    if (successor != null)
                    System.out.println(successor.value);
                    else {
                        System.out.println("-");
                    }
                }
                break;
            }

            if (node.value > value) {
                successor = node;
                node = node.leftTree;
            }
            else {
                node = node.rightTree;
            }

        }


        /*while (true) {
            if (node.value == value) {
                if (node.rightTree != null) {
                    node = node.rightTree;
                    while (node.leftTree != null) {
                        node = node.leftTree;
                    }
                    System.out.println(node.value);
                    break;
                }
                else {
                    Node successor = null;
                    Node ancestor = parent;
                    while (ancestor != node) {

                        if (ancestor.value > node.value) {
                            successor = ancestor;
                            ancestor = ancestor.leftTree;
                        }
                        else {
                            ancestor = ancestor.rightTree;
                        }
                    }
                    System.out.println(successor.value);
                    break;
                }
            }
            else if(node.value < value){
                node = node.rightTree;
            }
            else {
                node = node.leftTree;
            }*/

    }

    private static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftTree);
        System.out.println(node.value);
        inOrderTraversal(node.rightTree);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.leftTree = new Node(7);
        node.rightTree = new Node(35);
        node.leftTree.leftTree = new Node(5);
        node.leftTree.rightTree = new Node(9);
        node.rightTree.leftTree = new Node(30);
        node.rightTree.rightTree = new Node(45);
        Node start = node;
        //inOrderTraversal(start);
        inOrderSuccessor(start, 35);
        inOrderSuccessor(start, 9);
        inOrderSuccessor(start, 5);
        inOrderSuccessor(start, 30);
        inOrderSuccessor(start, 45);
    }
}
