package ds_facebook;

public class ElementSwapping {

    static void indexToSwap(int[] arr, int i, int k, int element) {
        int diff =0;
        int index = -1;
        for (int j=i+1;j<=k;j++) {
            int number = arr[j];
            if(element-number > diff) {
                diff = element-number;
                index = j;
            }
        }

        if (diff != 0) {
            swapElements(arr, index, i);;
        }
    }

    static void swapElements(int[] array, int endIndex, int startIndex) {
        for (int k = endIndex; k>startIndex;k--) {
            int temp = array[k];
            array[k] = array[k-1];
            array[k-1] = temp;
        }
    }

    static int[] findMinArray(int[] arr, int k) {
        // Write your code here

        for(int i=0;i<arr.length-k;i++) {
            indexToSwap(arr, i, k, arr[i]);
        }

        return arr;
    }

    public static void display(int[] array) {

        for (Integer i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n_1 = 3, k_1 = 2;
        int[] arr_1 = {5, 3, 1};
        int[] output_1 = findMinArray(arr_1,k_1);
        display(output_1);


        int n_2 = 5, k_2 = 3;
        int[] arr_2 = {8, 9, 11, 2, 1};
        int[] output_2 = findMinArray(arr_2,k_2);
        display(output_2);
    }
}
