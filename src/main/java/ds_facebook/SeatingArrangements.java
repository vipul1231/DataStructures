package ds_facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeatingArrangements {

    static int minOverallAwkwardness(int[] arr) {
        // Write your code here
        Arrays.sort(arr);
        int[] result = new int[arr.length];

        int front =0;
        int end = arr.length - 1;
        for (int i=arr.length-1;i>=0;i--) {
           if (i%2 == 0) {
               result[front++] = arr[i];
           }
           else {
               result[end--] = arr[i];
           }
        }

        for (Integer value : result) {
            System.out.print(value+" ");
        }
        System.out.println();

        int awk =0;
        for (int i=0;i<result.length;i++) {

            if (i+1 == result.length) {

                int abs1 = Math.abs(result[i] - result[0]);
                if (abs1 > awk) {
                    awk = abs1;
                }
                continue;
            }

            int abs = Math.abs(result[i] - result[i + 1]);
            if (abs > awk) {
                awk = abs;
            }

        }
        return awk;
    }


    public static void main(String[] args) {
        int[] arr = {5,10,6,8};
        System.out.println(minOverallAwkwardness(arr));
    }
}
