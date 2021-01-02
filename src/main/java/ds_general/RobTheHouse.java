package ds_general;

public class RobTheHouse {

    public static int rob_1(int[] nums) {
        int max1 =0,max2=0,max3=0,max4=0;

        if (nums.length == 1) {
            return nums[0];
        }

        for (int i=0;i<nums.length;i++) {
            int a = nums[i];
            //If first house is included
            if (i <= nums.length-2) {
                int b = a+max1;
                int c = max2;

                if (b < c) {
                    max2 = Math.max(b,c);
                    max1 = Math.max(b,c);
                }
                else {
                    max1 = Math.min(b,c);
                    max2 = Math.max(b,c);
                }

            }
            if (i > 0){
                int b = a+max3;
                int c = max4;

                if (b < c) {
                    max4 = Math.max(b,c);
                    max3 = Math.max(b,c);
                }
                else {
                    max3 = Math.min(b,c);
                    max4 = Math.max(b,c);
                }
            }
        }
        int maximum_1 = Math.max(max1,max2);
        int maximum_2 = Math.max(max3, max4);

        return Math.max(maximum_1, maximum_2);
    }

    public static  int rob(int[] nums) {
        int max1 = 0 , max2 = 0;

        for (int i=0;i<nums.length;i++) {
            int a = nums[i];
            //including the current position
            int b = a + max1;
            int c = max2;

            if (b < c) {
                max2 = Math.max(b,c);
                max1 = Math.max(b,c);
            }
            else {
                max1 = Math.min(b,c);
                max2 = Math.max(b,c);
            }

        }
        return max2;
    }

    public static void main(String[] args) {
        int[] array_1 = {1,2,3,1};
        System.out.println(rob(array_1));

        int[] array_2 = {2,7,9,3,1};
        System.out.println(rob(array_2));

        int[] array_3 = {5,1,1,5};
        System.out.println(rob(array_3));

        int[] array_4 = {2,3,2};
        System.out.println(rob_1(array_4));

        int[] array_5 ={1,2,3,1};
        System.out.println(rob_1(array_5));

        int[] array_6 = {0};
        System.out.println(rob_1(array_6));

        int[] array_7 = {1,2,1,1};
        System.out.println(rob_1(array_7));
    }
}
