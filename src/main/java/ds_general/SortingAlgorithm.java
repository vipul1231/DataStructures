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

    private static int partition(int[] arr, int l, int h) {

        int pivot = arr[0];

        int i = l, j = h;

        while (i<j) {
            do {
                i++;
            }while (i < j && arr[i] < pivot);

            do {
                j--;
            }while (i < j && arr[j] > pivot);
            if (i<j)
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }


    private static void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int index  = partition(array, low, high);
            quickSort(array, index+1, high);
            quickSort(array, low, index);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int swap = array[a];
        array[a] = array[b];
        array[b] = swap;
    }


    private static void display(int[] array) {
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] array_1 = {7,8,10,5,20,90,32,88};
        int[] array_2 = {7,76,32,13,17,20,10,11};
        selectionSort(array_1);
        quickSort(array_2, 0, array_2.length);
        display(array_2);
    }
}
