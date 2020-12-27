package ds_general;

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
            }else{
                max[i]=Math.max(nums[i], min[i-1]*nums[i]);
                min[i]=Math.min(nums[i], max[i-1]*nums[i]);
            }

            result = Math.max(result, max[i]);
        }

        return result;
    }


    public static int maxProduct_1(int[] nums) {

        int max = nums[0], min = nums[0];

        int maxProduct = nums[0];

        for (int i=1;i<nums.length;i++) {

            int a1 = nums[i] * max;
            int a2 = nums[i] * min;

            if (a1 >= a2 && a1 >= nums[i]) {
                max = a1;
            }
            else if(a2 >= a1 && a2 >= nums[i]) {
                max = a2;
            }
            else {
                max = nums[i];
            }


            if (a1 <= a2 && a1 <= nums[i]) {
                min = a1;
            }
            else if (a2 <= a1 && a2 <= nums[i]) {
                min = a2;
            }
            else {
                min = nums[i];
            }

            maxProduct = Math.max(maxProduct, max);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] array = {2,3,-2,4,4,2,8};
        int[] array_1 = {-2,0,-1};
        int[] array_2 = {0,3,7,-1,-3,8,9};
        int[] array_3 = {-1,-3,-3};
        int[] array_4 = {-3,-1,-1};
        System.out.println(maxProduct_1(array));
        //System.out.println(maxProduct(array));
        System.out.println(maxProduct_1(array_1));
        System.out.println(maxProduct_1(array_2));
        System.out.println(maxProduct_1(array_3));
        System.out.println(maxProduct_1(array_4));
    }
}
