package ds_facebook;

import java.util.Arrays;

public class LargestTripleProduct {

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
                if (arr[i] <= arr[leftChildIndex]) {
                    swap(arr, i, leftChildIndex);
                }
            }
            if(rightChildIndex < arr.length) {
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

    static int[] findMaxProduct(int[] arr) {
        // Write your code here
        int[] result = new int[arr.length];
        int[] maxHeapArray = new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            if (i<2) {
                result[i] = -1;
                maxHeapArray[i] = arr[i];
                heapify(maxHeapArray);
            }
            else {
                maxHeapArray[i] = arr[i];
                heapify(maxHeapArray);
                int[] topThree = getTopThreeElements(maxHeapArray, i);
                result[i] = topThree[0]*topThree[1]*topThree[2];
            }
        }
        return result;
    }

    static int[] getTopThreeElements(int[] arr, int index) {
        int[] arrayCopy = Arrays.copyOf(arr, arr.length);
        int[] bigThreeNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            bigThreeNumbers[i] = arrayCopy[0];
            arrayCopy[0] = arrayCopy[index];
            arrayCopy[index] = 0;
            index--;
            heapify(arrayCopy);
        }
        return bigThreeNumbers;
    }


    public static void main(String[] args) {
        int[] array_1 = {1, 2, 3, 4, 5};
        int[] array_2 = {2, 1, 2, 1, 2};
        int[] ans_1 = findMaxProduct(array_1);
        int[] ans_2 = findMaxProduct(array_2);
        System.out.println();
        for (int i=0;i<ans_1.length;i++) {
            System.out.print(ans_1[i]+" ");
        }

        System.out.println();
        for (int i=0;i<ans_2.length;i++) {
            System.out.print(ans_2[i]+" ");
        }
    }
}
