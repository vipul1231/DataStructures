package ds_general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeapSort {

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void heapify(int[] arr, int i) {
        int numToSwap = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild <= arr.length - 1 && arr[numToSwap] < arr[leftChild]) {
            numToSwap = leftChild;
        }

        if (rightChild <= arr.length - 1 && arr[numToSwap] < arr[rightChild]) {
            numToSwap = rightChild;
        }

        if (i != numToSwap) {
            swap(arr, i, numToSwap);
            heapify(arr, numToSwap);
        }
    }

    private static void heap(int[] arr) {
        for (int i=arr.length-1;i>=0;i--) {
            heapify(arr, i);
        }
    }

    private static int heapSort(int[] arr) {

        int result = 0;
        List<Integer> arrayList = new ArrayList<>();
        for (int i=arr.length-1;i>=0;i--) {
            heap(arr);
            arrayList.add(arr[0]);
            arr[0] = arr[i];
            arr[i] = 0;
        }
        if (arrayList.size() %2 == 0){
            int num1 = arrayList.get(arrayList.size()/2) ;
            int num2  = arrayList.get(arrayList.size()/2 - 1);

            return (num1+num2)/2;
        }
        else {
            return arrayList.get(arrayList.size()/2);
        }
    }

    static int[] findMedian(int[] arr) {

        int[] result = new int[arr.length];
        int[] answer = new int[arr.length];
        for (int i=0;i<arr.length;i++) {

            if (i==0) {
                result[i] = arr[i];
                answer[i] = arr[i];
                continue;
            }
            if (i==1) {
                result[i] = (arr[i] + arr[i-1])/2;
                answer[i] = arr[i];
            }

            else {
                answer[i] = arr[i];
                int[] nums = Arrays.copyOf(answer,i+1);
                result[i] = heapSort(nums);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr_1 = {10, 20, 15, 12, 40, 25, 18};
        int[] arr_3 = {2, 4, 7, 1, 5, 3};
        int[] arr_2 = {5, 15, 1, 3};
        heap(arr_1);

        for(int i=0;i< arr_1.length;i++) {
            System.out.print(arr_1[i] + " ");
        }
       /* int[] ans = findMedian(arr_1);
        int[] ans_1 = findMedian(arr_2);
        int[] ans_2 = findMedian(arr_3);
        System.out.println(Arrays.stream(ans).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(ans_1).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(ans_2).boxed().collect(Collectors.toList()));*/
    }
}
