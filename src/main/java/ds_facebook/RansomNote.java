package ds_facebook;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RansomNote {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
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
