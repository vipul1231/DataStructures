package ds_facebook;

import java.util.Scanner;

class Node {
    int value;
    Node node;
    Node(int value, Node node) {
        this.value = value;
        this.node = node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }
    public int getValue() {
        return value;
    }
}


public class ReverseLinklist {

    private static void traverseLinkList(Node start) {
        Node node = start;
        while (node!=null) {
            System.out.print(node.getValue()+" ");
            node = node.getNode();
        }
    }

    private static Node reverseLinkList(Node start) {

        Node head = null;
        Node begin = start;
        Node next = begin.getNode();

        while (next != null) {
            Node temp = begin;
            begin = next;
            next = next.getNode();
            begin.setNode(temp);
            if (head == null) {
                head = temp;
                temp.setNode(null);
            }
        }

        return begin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node start = null;
        Node next = null;
        int number = scanner.nextInt();
        for(int i=0;i<number;i++) {
            Node node = new Node(scanner.nextInt(), null);
            if(start == null) {
                start = node;
                next = node;
            }
            else {
                next.setNode(node);
                next = next.getNode();
            }
        }
        traverseLinkList(start);
        start = reverseLinkList(start);
        System.out.println();
        traverseLinkList(start);
    }
}
