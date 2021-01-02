package ds_general;

import java.util.Arrays;

public class SortingAlgorithm {



    /**
     * Merge two arrays
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static int[] returnTwoMergedArray(int[] arr1, int[] arr2) {

        int[] arr3 = new int[arr1.length+arr2.length];

        int ptr1 = 0;
        int ptr2 = 0;
        int i =0;
        for (i=0;i<arr3.length;i++) {

            int a = ptr1 < arr1.length ? arr1[ptr1] : -1;
            int b = ptr2 < arr2.length ? arr2[ptr2] : -1;

            if (a == -1 || b == -1) {
                break;
            }


            if (a>b) {
                arr3[i] = b;
                ptr2 += 1;
            }
            else if (a<b) {
                arr3[i] = a;
                ptr1 += 1;
            }
            else {
                arr3[i] = a;
                arr3[i+1] = a;
                i = i+2;
                ptr1 += 1;
                ptr2 += 1;
            }
        }

        if (ptr2 < arr2.length){
            for (;i<arr3.length;i++) {
                arr3[i] = arr2[ptr2++];
            }
        }
        else if(ptr1 < arr1.length) {
            for (;i<arr3.length;i++) {
                arr3[i] = arr1[ptr1++];
            }
        }

        return arr3;
    }

    public static int mergeArrayWithIndex(int[] array, int low, int mid, int high) {

        int[] a = Arrays.copyOf(array, mid);
        int[] b = Arrays.copyOf(array, mid+1);
        int[] ab = returnTwoMergedArray(a, b);
        display(ab);
        System.arraycopy(ab,0, array,ab.length, ab.length);
        System.out.println("Print");
        return 0;
    }

    public static void mergeSort(int[] array, int low, int high) {

        if (low < high) {
            int mid = (low + high)/2;
            mergeSort(array, low, mid);
            mergeSort(array,mid+1, high);

            mergeArrayWithIndex(array,low, mid, high);

            System.out.println(low+" "+mid+" "+high);

        }
    }

    /**
     * Selection sort algorithm
     *
     * @param array
     */
    private static void selectionSort(int[] array) {

        for (int i=0;i<array.length;i++) {
            int low  = array[i];
            int l = 0;
            for (int j =i+1;j<array.length;j++) {
                if (array[j] < low) {
                    low = array[j];
                    l = j;
                }
            }
            if (l!=0)
            swap(array, i, l);
        }
        display(array);
    }

    /**
     * Quick sort
     *
     * @param arr   arr
     * @param l     left
     * @param h     right
     * @return      pivot
     */
    private static int partition(int[] arr, int l, int h) {

        int pivot = arr[l];

        int i = l+1, j = h-1;

        while (i<j) {
            do {
                if (arr[i] <= pivot)
                i++;
            }while (i <= arr.length-1 && arr[i] <= pivot);

            if(i >=arr.length) {
                i = arr.length-1;
            }
            do {
                if (arr[j] > pivot){
                    j--;
                }
            }while (arr[j] > pivot);
            if (i<j)
            swap(arr, i, j);
        }
        if (l!=j && arr[l] > arr[j])
        swap(arr, l, j);
        return j;
    }


    private static void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int index  = partition(array, low, high);
            quickSort(array, low, index);
            quickSort(array, index+1, high);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int swap = array[a];
        array[a] = array[b];
        array[b] = swap;
    }


    private static void display(int[] array) {
        System.out.println();
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array_1 = {7,8,10,5,20,90,32,88};
        int[] array_2 = {7,76,32,13,17,20,10,11};
        int[] array_3 = {7,8,10,5,20};
        int[] array_4 = {10, 80, 30, 90, 40, 50, 70};
        int[] array_5 = {10, 7, 8, 9, 1, 5};
        int[] array_6 = {};

        int[] array_7 = {10, 6, 2, 3, 1, 7};
        //Selection Sort
        /*selectionSort(array_1);

        //Quick Sort
        quickSort(array_3, 0, array_3.length);
        display(array_3);
        quickSort(array_2, 0, array_2.length);
        display(array_2);
        quickSort(array_4, 0, array_4.length);
        display(array_4);
        quickSort(array_5, 0, array_5.length);
        display(array_5);
        quickSort(array_6,0, array_6.length);
        display(array_6);*/

        mergeSort(array_7, 0, array_7.length);
        display(array_7);
        //Merge sort


    }
}
