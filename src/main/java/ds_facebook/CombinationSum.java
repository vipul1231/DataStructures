package ds_facebook;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static public List<Integer> combinationSum(int[] candidates, int index, int target) {




        return null;

    }

    static public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<candidates.length;i++) {
            result.add(combinationSum(candidates, i, target));
        }
        return result;
    }


    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        combinationSum(candidates, target);
    }
}
