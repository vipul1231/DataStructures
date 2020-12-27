package ds_general;

import java.util.Arrays;

public class MaximumProduct {

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],nums[0]*nums[1]*nums[nums.length-1]);
    }


    public static void main(String[] args) {
        int[] array_1 = {1,2,3};
        int[] array_2 = {-8,-7,0,1,8};
        int[] array_3 = {1,2,3,4};
        System.out.println(maximumProduct(array_1));
        System.out.println(maximumProduct(array_2));
        System.out.println(maximumProduct(array_3));
    }
}
