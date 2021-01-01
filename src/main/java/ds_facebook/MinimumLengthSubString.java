package ds_facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumLengthSubString {

    static int minLengthSubstring(String s, String t) {
        // Write your code here
        Map<String, Long> ocrMap = Stream.of(t.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String[] s1 = s.split("");
        Map<String, Integer> windowMap = new HashMap<>();
        int start =0;
        int length = -1;
        for (int i=0;i<s1.length;i++) {
            String a = s1[i];
            if (windowMap.containsKey(a)) {
                int value = windowMap.get(a);
                windowMap.put(a, ++value);
            }
            else {
                windowMap.put(a, 1);
            }

            Set<String> sets= windowMap.keySet().stream().filter(ocrMap::containsKey).collect(Collectors.toSet());
            //System.out.println(sets);
            if (sets.equals(ocrMap.keySet())){
                //now it is time to contract the window
                //System.out.println("Length: "+length +", subString: "+s.substring(start, i+1));
                boolean isWindowValid = validateMapWindow(ocrMap, windowMap);
                while (isWindowValid) {
                    length = (i+1) - start;
                    String b = s1[start];
                    int value = windowMap.get(b);
                    windowMap.put(b, --value);
                    isWindowValid = validateMapWindow(ocrMap, windowMap);
                    if (!isWindowValid) {
                        start += 1;
                        break;
                    }
                    else {
                        start = start +1;
                        length = (i+1)-start;
                  //      System.out.println("Length: "+length +", subString: "+s.substring(start, i+1));
                    }

                }
            }
        }
        return length;
    }

    private static boolean validateMapWindow(Map<String,Long> ocrMap, Map<String,Integer> windowMap) {

        for (String key : ocrMap.keySet()) {
            Long minOcr = ocrMap.get(key);
            int ocrInWindow = windowMap.get(key);
            if (ocrInWindow < minOcr) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "dcbefebce";
        String t = "fd";

        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(minLengthSubstring(s, t));
        System.out.println(minLengthSubstring(s1, t1));

        String s2 = "ABAACBAB";
        String t2 = "ABC";
        System.out.println(minLengthSubstring(s2, t2));

        String s3 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t3 = "cbccfafebccdccebdd";
        System.out.println(minLengthSubstring(s3, t3));

        String s4 = "cabwefgewcwaefgcf";
        String t4 = "cae";
        System.out.println(minLengthSubstring(s4, t4));
    }
}