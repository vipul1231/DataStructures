package ds_facebook;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KDiffPairs {

    static public int findPairs(int[] nums, int k) {
        Map<Integer, Long> set =  IntStream.of(nums).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        int pair =0;

        for (Integer keys : set.keySet()) {
            int result = keys - k;

            if (result == keys) {
                if(set.get(result) >= 2) {
                    pair = pair + 1;
                }
                continue;
            }

            if (set.containsKey(result)) {
                pair = pair+1;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        int[] array_1 = {3,1,4,1,5};
        int[] array_2 = {1,2,3,4,5};
        int[] array_3 = {1,3,1,5,4};
        int[] array_4 ={1,2,4,4,3,3,0,9,2,3};
        int[] array_5 = {-1,-2,-3};
        System.out.println(findPairs(array_1, 2));
        System.out.println(findPairs(array_2, 1));
        System.out.println(findPairs(array_3, 0));
        System.out.println(findPairs(array_4, 3));
        System.out.println(findPairs(array_5, 1));
    }
}
