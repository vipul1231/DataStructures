package ds_general;

import java.util.*;

public class CombinationSum2 {

    static Set<List<Integer>> combination = new HashSet<>();
    public static void combinationSum2(int[] candidates, int target, int index, List<Integer> combos) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            List<Integer> newList = new ArrayList<>(combos);
            Collections.sort(newList);
            combination.add(new ArrayList<>(newList));
            return;
        }

        for (int i=0;i<candidates.length;i++) {
            int number = candidates[i];
            if (number <= target) {
                combos.add(number);
                combinationSum2(Arrays.copyOfRange(candidates, i+1, candidates.length), target - number, 0, combos);
                combos.remove(combos.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinationSum2(candidates, target, 0, new ArrayList<>());

        return new ArrayList<>(combination);
    }

    public static void main(String[] args) {
        int[] array = {10,1,2,7,6,1,5};
        int target = 8;
        //Arrays.sort(array);
        System.out.println(combinationSum2(array, target));
        combination.clear();

        int[] array_1 = {2,5,2,1,2};
        int target_1 = 5;
        System.out.println(combinationSum2(array_1, target_1));
    }
}
