package ds_facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node_1 {
    int value;
    Node_1 node;
    Node_1(int value, Node_1 node) {
        this.value = value;
        this.node = node;
    }

    public void setNode(Node_1 node) {
        this.node = node;
    }

    public Node_1 getNode() {
        return node;
    }
    public int getValue() {
        return value;
    }
}


public class ReverseLinklist {

    private static void traverseLinkList(Node_1 start) {
        Node_1 node = start;
        while (node!=null) {
            System.out.print(node.getValue()+" ");
            node = node.getNode();
        }
    }

    private static void traverseLinkList(Node start) {
        Node node = start;
        while (node!=null) {
            System.out.print(node.getData()+" ");
            node = node.getNext();
        }
    }

    private static Node_1 reverseLinkList(Node_1 start) {

        Node_1 head = null;
        Node_1 begin = start;
        Node_1 next = begin.getNode();

        while (next != null) {
            Node_1 temp = begin;
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

    static class Node {
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    static Node[] createLinkListFromArrayList(List<Integer> arrayList) {
        Node start = null;
        Node next = null;
        Node[] nodeStartEnd = new Node[2];
        for (Integer integer : arrayList) {
            Node value = new Node(integer);
            if (start == null) {
                start = value;
                next = start;
            } else {
                next.setNext(value);
            }
        }
        nodeStartEnd[0] = start;
        nodeStartEnd[1] = next;
        return nodeStartEnd;
    }

    static Node reverse(Node head) {
        // Write your code here
        Node start = head;
        Node startSwap = null;
        List<Integer> arrayList = new ArrayList<>();
        while (start != null) {
            int data = start.getNext().getData();
            if(data%2 == 0) {
                if (startSwap == null) {
                    startSwap = start;
                }

                arrayList.add(data);
            }
            else if( data%2 == 1 && startSwap != null && arrayList.size() > 0) {
                Node nodeJoinPoint = start.getNext();
                Collections.reverse(arrayList);
                Node[] node = createLinkListFromArrayList(arrayList);
                startSwap.setNext(node[0]);
                node[1].setNext(nodeJoinPoint);
            }
            start = start.getNext();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Node_1 start = null;
        Node_1 next = null;
        int number = scanner.nextInt();
        for(int i=0;i<number;i++) {
            Node_1 node = new Node_1(scanner.nextInt(), null);
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
        traverseLinkList(start);*/
        Node start = null;
        Node next = null;
        int number = scanner.nextInt();
        for(int i=0;i<number;i++) {
            Node node = new Node(scanner.nextInt());
            if(start == null) {
                start = node;
                next = node;
            }
            else {
                next.setNext(node);
                next = next.getNext();
            }
        }

        traverseLinkList(start);

        reverse(start);
        traverseLinkList(start);
    }
}
