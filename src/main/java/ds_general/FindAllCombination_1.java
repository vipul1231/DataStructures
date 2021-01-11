package ds_general;

import java.util.ArrayList;
import java.util.List;

public class FindAllCombination_1 {

    static List<List<Integer>> findCombos = new ArrayList<>();
    public static void combine(int n, int index, int k, List<Integer> combos) {

        if (combos.size() == k) {
            findCombos.add(new ArrayList<>(combos));
            return;
        }

        for (int i=index;i<=n;i++) {
            combos.add(i);
            combine(n, ++index, k, combos);
            combos.remove(combos.size() -1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        combine(n, 1, k, new ArrayList<>());
        return findCombos;
    }


    public static void main(String[] args) {
        combine(4,2);
        System.out.println(findCombos);
    }
}
