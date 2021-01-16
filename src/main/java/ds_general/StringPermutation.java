package ds_general;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPermutation {


    public static boolean checkInclusion(String s1, String s2) {

        Map<String, Long> countMap = Arrays.stream(s1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String[] arr = s2.split("");
        Map<String, Integer> valueMap = new HashMap<>();
        int start = -1, end = 0;

        while (start != end) {

            //start compacting window size.
            if (countMap.size() == valueMap.size()) {
                start = start +1;
                while (start != end) {
                    String val = arr[start];
                    if (valueMap.containsKey(val)) {
                        //Do something
                        int length = end - start;
                        if (length == s1.length()) {
                            return true;
                        } else {
                            Integer count = valueMap.get(val);

                            if (countMap.get(val) < count) {
                                valueMap.put(val, --count);
                            }
                        }
                    }
                    start++;
                }
            }

            //add element in window
            if (end >= arr.length) {
                break;
            }
            String val = arr[end];
            if (countMap.containsKey(val)) {
                Integer c = valueMap.get(val);
                if (valueMap.containsKey(val)) {
                    valueMap.put(val, ++c);
                }
                else {
                    valueMap.put(val, 1);
                }
            }

            end++;
        }
        return false;
    }

    private static boolean checkTwoStringContentIsEqual(String given, String check) {
        int total = Arrays.stream(given.split("")).mapToInt( i -> (int)i.charAt(0)).sum();

        int sum = Arrays.stream(check.split("")).mapToInt( i -> (int)i.charAt(0)).sum();
        return total == sum;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));

        String s3 = "ab";
        String s4 = "eidboaoo";
        System.out.println(checkInclusion(s3, s4));

        String s5 = "abc";
        String s6 = "dsderefrrgrgbca";
        System.out.println(checkInclusion(s5, s6));

        String s7 = "adc";
        String s8 = "dcdeaaaaaa";
        System.out.println(checkInclusion(s7, s8));
    }
}
