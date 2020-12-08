package ds_facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RansomNote {


    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int integer : array_a) {
            if(countMap.containsKey(integer)) {
                Integer value = countMap.get(integer);
                countMap.put(integer, value);
            }
            else {
                countMap.put(integer, 1);
            }
        }

        for(int a : array_b) {
            Integer count = countMap.get(a);
            if(count != null && count != 0) {
                countMap.put(a, --count);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        int[] array = new int[5];

        Map<String, Long> magzineMap= Stream.of(scanner.nextLine().split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> noteMap= Stream.of(scanner.nextLine().split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String words : noteMap.keySet()) {
            long count_1 = noteMap.get(words);
            Long count_2 = magzineMap.get(words);
            if(count_2 == null || count_1 > count_2) {
                System.out.println("No");
                System.exit(0);
            }
        }
        System.out.println("Yes");
        scanner.close();
    }
}
