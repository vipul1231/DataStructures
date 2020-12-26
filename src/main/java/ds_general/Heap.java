package ds_general;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfNodes = scanner.nextInt();
        int[] input = new int[noOfNodes];
        for(int i=0;i<noOfNodes;i++) {
            input[i] = scanner.nextInt();
        }

        //nodeOfNodes-1/2 gives last leaf nodes.
        List<Swap> swapList = new ArrayList<>();
        for (int i=((noOfNodes)/2)-1;i>=0;i--){
            heapify(input, i, input.length, swapList);
        }
        System.out.println(swapList.size());
        for(Swap swap : swapList) {
            System.out.println(swap);
        }

        for(int i=0;i<input.length;i++) {
            System.out.print(input[i]+" ");
        }

        System.out.println();
        int[] arr = {10, 5, 8, 9};
        heapify(arr);
        displayArray(arr);
        scanner.close();
    }

    private static void displayArray(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }

    /**
     *  Heapify
     *
     * @param arr
     */
    public static void heapify(int[] arr) {

        for(int i=arr.length -1;i>=0;i--) {
            int leftChildIndex = 2*i+1;
            int rightChildIndex = 2*i+2;

            if (leftChildIndex < arr.length) {

                if (arr[i] < arr[leftChildIndex]) {
                    swap(arr, i, leftChildIndex);
                }
            }
            else if(rightChildIndex < arr.length) {
                if (arr[i] < arr[rightChildIndex]) {
                    swap(arr, i, rightChildIndex);
                }
            }
        }
    }


    private static void swap(int[] arr, int index_1, int index_2) {
        int swap = arr[index_1];
        arr[index_1] = arr[index_2];
        arr[index_2] = swap;
    }

    static class Swap {
        int i;
        int j;

        public Swap(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return i+" "+j;
        }

    }

    /**
     * Left Index
     *
     * @param i
     * @return
     */
    public static int leftIndex(int i) {
        return 2*i+1;
    }

    /**
     * Right Index
     * @param j
     * @return
     */
    public static int rightIndex(int j) {
        return 2*j+2;
    }


    public static void heapify(int[] input, int i, int length, List<Swap> swap) {

        int maxIndex = i;

        int left = leftIndex(i);

        if(left < length && input[left] < input[maxIndex]) {
            maxIndex = left;
        }

        int right = rightIndex((i)) ;

        if(right < length && input[right] < input[maxIndex]) {
            maxIndex = right;
        }

        if(maxIndex != i) {
            int temp = input[i];
            input[i] = input[maxIndex];
            input[maxIndex] = temp;
            swap.add(new Swap(i, maxIndex));
            heapify(input, maxIndex, length, swap);
        }
    }
}
