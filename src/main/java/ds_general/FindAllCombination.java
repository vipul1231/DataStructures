package ds_general;

import java.util.ArrayList;
import java.util.List;

public class FindAllCombination {

    static List<List<Integer>> combinationSum = new ArrayList<>();

    static List<Integer> integerList = new ArrayList<>();

    public static List<Integer> getAllChoices(int index, int[] candidates, int target) {

        if (target < 0) {
            return new ArrayList<>();
        }
        if (target == 0) {
            return new ArrayList<>();
        }
        if (index == candidates.length-1) {
            List<Integer> p = new ArrayList<>();
            p.add(candidates[index]);
            return p;
        }

        int number = candidates[index];
        List<Integer> choices = getAllChoices(index+1, candidates, target);
        List<Integer> singleNumber  = getAllChoices(index, candidates, target - candidates[index]);

        System.out.println(singleNumber);
        return integerList;
    }

    public static void getAllChoices(int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> result) {

        if (target < 0) return;
        if (target == 0)  {
            result.add(new ArrayList<>(temp));
        }

        for (int i=index;i<candidates.length;i++) {
            temp.add(candidates[i]);
            getAllChoices(i, candidates, target-candidates[i], temp, result);
            temp.remove(temp.size() -1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        System.out.println(getAllChoices(0, candidates, target));

        List<List<Integer>> result = new ArrayList<>();
        getAllChoices(0, candidates, target, new ArrayList<>(), result);
        System.out.println(result);
        return combinationSum;
    }

    public static void combine_1(int n, int k, List<Integer> list, List<List<Integer>> result, int val) {

        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=val;i<=n;i++) {
            list.add(i);
            System.out.println(list);
            combine_1(n,k, list, result, i+1);
            list.remove(list.size()-1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combine = new ArrayList<>();
        combine_1(n, k, new ArrayList<>(), combine, 1);
        return combine;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4};

        //System.out.println(findCombinations(array, 7));

        int[] array_1 = {2,3};
        //System.out.println(combinationSum(array_1, 5));


        System.out.println(combine(5,3));
    }
}
