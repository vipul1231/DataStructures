package ds_general;

public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int maxSum =nums[0], currSum =0;

        if (nums.length == 1) {
            return nums[0];
        }
        for (int num : nums) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum *= num;
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int[] array_1 = {-2147483647};
        int[] array_2 = {-2,-1};
        System.out.println(maxSubArray(array));
        System.out.println(maxSubArray(array_1));
        System.out.println(maxSubArray(array_2));
    }
}
