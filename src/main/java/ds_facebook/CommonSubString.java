package ds_facebook;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonSubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<number;i++) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();

            if(str1.length() < str2.length()) {
                Map<String, Long> stringMap = Stream.of(str2.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                boolean notFound = true;
                for(String input : str1.split("")) {
                    if(stringMap.containsKey(input)) {
                        System.out.println("YES");
                        notFound = false;
                        break;
                    }
                }

                if (notFound) {
                    System.out.println("NO");
                }
            }

            else if(str2.length() <= str1.length()) {
                Map<String, Long> stringMap = Stream.of(str1.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                boolean notFound = true;
                for(String input : str2.split("")) {
                    if(stringMap.containsKey(input)) {
                        System.out.println("YES");
                        notFound = false;
                        break;
                    }
                }

                if (notFound) {
                    System.out.println("NO");
                }
            }


        }
        scanner.close();
    }
}
