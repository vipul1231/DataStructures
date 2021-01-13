package ds_general;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllCombinationOfString {

    static List<List<Integer>> combination = new ArrayList<>();

    private static List<List<Integer>> findAllCombos(int[] array) {

        if (array.length == 0) {
            List<List<Integer>> emptyList = new ArrayList<>();
//            combination.add(emptyList);
            emptyList.add(new ArrayList<>());
            return emptyList;
        }

        int first = array[0];

        int[] subArray = Arrays.copyOfRange(array, 1, array.length);
        List<List<Integer>> comboWithOutFirstElement = findAllCombos(subArray);

        List<List<Integer>> combination = new ArrayList<>();
        for (List<Integer> list : comboWithOutFirstElement) {
            combination.add(new ArrayList<>(list));
            list.add(first);
            combination.add(list);
        }
        System.out.println(combination);
        return combination;
    }

    private static void findAllCombos(int[] array, List<Integer> combos) {

        for (int i = 0;i<array.length;i++) {
           combos.add(array[i]);
           combination.add(new ArrayList<>(combos));
           findAllCombos(Arrays.copyOfRange(array,i+1,array.length), combos);
           combos.remove(combos.size() -1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        findAllCombos(arr, new ArrayList<>());
        System.out.println(combination);
        combination.clear();
        findAllCombos(arr);
        System.out.println(combination);
    }
}
