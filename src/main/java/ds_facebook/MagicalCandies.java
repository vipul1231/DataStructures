package ds_facebook;

public class MagicalCandies {

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

    static int maxCandies(int[] arr, int k) {
        // Write your code here
        heapify(arr);
        int total = 0;
        for (int i = 0; i < k; i++) {
            int candies = arr[0];
            total += candies;
            double remainingCandies = Math.floor((double) candies / 2);
            arr[0] = arr[arr.length -1];
            arr[arr.length-1] = (int)remainingCandies;
            heapify(arr);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] array_1 = {2, 1, 7, 4, 2};
        int[] array_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        System.out.println(maxCandies(array_1,3));
        System.out.println(maxCandies(array_2, 3));
    }
}
