package ds_general;

public class SortingAlgorithm {

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
        selectionSort(array_1);
        quickSort(array_3, 0, array_3.length);
        display(array_3);
        quickSort(array_2, 0, array_2.length);
        display(array_2);
        quickSort(array_4, 0, array_4.length);
        display(array_4);
        quickSort(array_5, 0, array_5.length);
        display(array_5);
        quickSort(array_6,0, array_6.length);
        display(array_6);

    }
}
