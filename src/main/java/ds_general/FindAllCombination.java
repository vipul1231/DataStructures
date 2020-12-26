package ds_general;

import java.util.ArrayList;
import java.util.List;

public class FindAllCombination {

    static void findAllChoices(int[] candidates, int target, int start, List<List<Integer>> answer, List<Integer> temp) {

        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            target -= candidates[i];
            // if target minus the candidate is less than zero, then there's no need to try the rest candidates
            // because the rest candidats are bigger than the current candidate
            if (target < 0) {
                break;
            }
            temp.add(candidates[i]);
            findAllChoices(candidates, target, i, answer, temp);
            temp.remove(temp.size() - 1);
            target += candidates[i];
        }
    }


    static List<List<Integer>> findCombinations(int[] n, int target) {

        List<List<Integer>> combinationsList = new ArrayList<>();
        findAllChoices(n, target, 0, combinationsList, new ArrayList<>());

        return combinationsList;
    }


    static List<List<Integer>> allChoices = new ArrayList<>();

    static void findAllChoices(int[] n, int target, List<Integer> combination) {
        if (target == 0) {
            allChoices.add(combination);
            return;
        }
        for (int value : n) {
            target -= value;

            if (target < 0) {
                break;
            }

            combination.add(value);
            findAllChoices(n, target, combination);
            combination.remove(combination.size() - 1);
            target += value;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};

        //System.out.println(findCombinations(array, 7));

        int[] array_1 = {2,3,6,7};
        //System.out.println(findCombinations(array_1, 7));

        findAllChoices(array, 7, new ArrayList<>());
        System.out.println(allChoices);
    }
}
