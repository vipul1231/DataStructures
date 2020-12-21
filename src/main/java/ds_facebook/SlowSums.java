package ds_facebook;

import java.util.Arrays;

public class SlowSums {

    static int getTotalTime(int[] arr) {
        // Write your code here
        Arrays.sort(arr);

        int penalty =0;
        for(int i=arr.length-1;i>0;i--) {
            int num1 = arr[i];
            int num2 = arr[i-1];
            penalty = penalty +(num1+num2);
            arr[i-1] = num1+num2;
        }


        return penalty;
    }


    public static void main(String[] args) {

        int[] arr_1 = {4,2,1,3};
        int[] arr_2 = {7,4,8,10};
        int[] arr_3 = {2, 3, 9, 8, 4};
        System.out.println(getTotalTime(arr_1));
        System.out.println(getTotalTime(arr_2));
        System.out.println(getTotalTime(arr_3));
    }
}
