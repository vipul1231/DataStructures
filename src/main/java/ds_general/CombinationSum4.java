package ds_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum4 {

    static List<List<Integer>> combinations = new ArrayList<>();


    public static void combos(int[] nums, int target, List<Integer> combos, Map<Integer, Integer> dp) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<>(combos));
            return;
        }

        for (int num : nums) {
            int newTarget = target - num;
            combos.add(num);

            combos(nums, newTarget, combos, dp);
            if (newTarget > 0)
            dp.put(newTarget, combinations.size());
            combos.remove(combos.size() - 1);
        }
    }

    public static int combinationSum4(int[] nums, int target) {
        combos(nums, target, new ArrayList<>(), new HashMap<>());
        return combinations.size();
    }


    public  static int combinationSum4_dp(int[] nums, int target) {

        if (target == 0) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i=1;i<=target;i++) {

            for (int num : nums) {
                if (i >= num)
                    dp[i] = dp[i] + dp[i - num];
            }
        }

        return dp[target];
    }


/*    public static List<List<Integer>> combinationSum4(int[] nums, int index, int target, List<Integer> combos) {

        if (target < 0) {
            return new ArrayList<>();
        }
        else if(target == 0) {
            List<List<Integer>> combs = new ArrayList<>();
            combs.add(new ArrayList<>());
            return combs;
        }

        if (index == nums.length) {
            return new ArrayList<>();
        }

        int num = nums[index];
        List<List<Integer>> ans = combinationSum4(nums, index+1, target, combos);
        List<List<Integer>> other = combinationSum4(nums, index, target-nums[index], combos);

        System.out.println("Ans : "+ans+", other: "+other+", Value: "+nums[index]+", target "+target);
        for (List<Integer> ch : other) {
            ch.add(num);
            ans.add(ch);
        }
        return ans;
    }*/

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(combinationSum4_dp(a, 6));
        //System.out.println(combinations);
    }
}
