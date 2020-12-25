package ds_facebook;

import java.util.Arrays;

/**
 * TODO
 */
public class MedianStream {

    /**
     *  Heapify
     *
     * @param arr
     */
    public static void heapify(int[] arr, int index) {

        for(int i=arr.length-index;i>=0;i--) {
            int leftChildIndex = 2*i+1;
            int rightChildIndex = 2*i+2;

            if (leftChildIndex < arr.length-index) {
                if (arr[i] <= arr[leftChildIndex]) {
                    swap(arr, i, leftChildIndex);
                }
            }
            if(rightChildIndex < arr.length-index) {
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

    static int[] findMedian(int[] arr) {
        // Write your code here
        int[] result = new int[arr.length];
        int[] dummyArray = new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            if (i==0) {
                result[i] = arr[i];
                dummyArray[i] = arr[i];
                continue;
            }
            else if (i==1) {
                result[i] = (arr[i] + arr[i-1])/2;
                dummyArray[i] = arr[i];
                continue;
            }
            dummyArray[i] = arr[i];
            //heapify(dummyArray);
            heapSortAndFindMiddle(dummyArray, i);

            if ((i+1) %2 == 1) {
                int index = (i+1)/2;
                result[i] = dummyArray[index];
            }
            else {
                int index = (i+1)/2;
                int index_1 = index -1;
                result[i] = (dummyArray[index] + dummyArray[index_1])/2;
            }
        }
        return result;
    }
    public static int heapSortAndFindMiddle(int[] dummyArray, int index) {

        int[] array = Arrays.copyOf(dummyArray, index+1);
        heapify(array, index+1);
        for (int i=array.length-1;i>0;i--) {
            int number = array[0];
            array[0] = array[array.length-1];
            array[i] = number;
            heapify(array,i);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array_1 = {5, 15, 1, 3};
        int[] array_2 = {1, 2};

        int[] result_1 = findMedian(array_1);
        int[] result_2 = findMedian(array_2);

        System.out.println();
        for (int i=0;i<result_1.length;i++) {
            System.out.print(result_1[i]+" ");
        }
        System.out.println();
        for (int i=0;i<result_2.length;i++) {
            System.out.print(result_2[i]+" ");
        }
    }
}
