package ratelimiter;

public class Jump {

    public static int jump(int[] nums) {

        int maxReach = 0;
        /*for (int i=0;i<nums.length -1 ;i++) {
            int num = nums[i] + i;

            if (num > maxReach && maxReach < nums.length-1) {
                maxReach = num;
                jump++;

                for(int j=i+1;j<(nums[i] + i) && j < nums.length-1;j++) {
                    int newReach = nums[j] + j;
                    if (newReach > maxReach && maxReach < nums.length-1) {
                        maxReach = newReach;
                        jump++;
                    }
                }
            }
         }

        if (maxReach < nums.length-1) {
            return 0;
        }*/

        int currReach = 0;
        int currMax =0;
        int jump = 0;

        for (int i=0;i<nums.length - 1;i++) {
            if (i+nums[i] > currMax) {
                currMax = i + nums[i];
            }
            if ( i == currReach) {
                jump++;
                currReach = currMax;
            }
        }


        return jump;
    }

    public static boolean canJump(int[] nums) {
        int maxSoFar = 0;
        boolean isUnReachable = false;
        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }

        for (int i=0;i<nums.length;i++) {
            int distance = nums[i] + i;

            if (distance > maxSoFar) {
                maxSoFar = distance;
            }

            if (i >= maxSoFar && i!=nums.length-1) {
                isUnReachable = true;
                break;
            }
        }

        return !isUnReachable;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums_1 = {3,2,1,0,4};
        int[] nums_2 = {1,1,2,5,2,1,0,0,1,3};
        int[] nums_3 = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        //System.out.println(canJump(nums));
        //System.out.println(canJump(nums_1));
        //System.out.println(canJump(nums_2));
        //System.out.println(canJump(nums_3));


        System.out.println(Integer.toString(jump(nums)) + canJump(nums));
        System.out.println(Integer.toString(jump(nums_1)) + canJump(nums_1));
        System.out.println(Integer.toString(jump(nums_2)) + canJump(nums_2));
        System.out.println(Integer.toString(jump(nums_3)) + canJump(nums_3));
    }


}
