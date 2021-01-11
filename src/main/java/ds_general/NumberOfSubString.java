package ds_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSubString {

    public static int numberOfSubString(String s) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == 'a') {
                a.add(i);
            }
            else if(s.charAt(i) == 'b') {
                b.add(i);
            }
            else {
                c.add(i);
            }
        }

        int cnt =0, n =0;
        while (!a.isEmpty() && !b.isEmpty() && !c.isEmpty()) {
            int v = 0;
            char c1 = s.charAt(n);
            if (c1 == 'a') {
                v = Math.max(b.get(0),c.get(0));
                a.remove(0);
            }
            else if(c1 == 'b') {
                v = Math.max(a.get(0), c.get(0));
                b.remove(0);
            }
            else {
                v = Math.max(a.get(0), b.get(0));
                c.remove(0);
            }
            n++;
            cnt += (s.length() - v);
        }

        return cnt;
    }

    public static int numberOfSubstrings(String s) {

        String[] array = s.split("");
        int count = 0;
        int start = 0;
        int end = 0;
        Map<String, Integer> windowMap = new HashMap<>();
        while(end != s.length()) {
            String s1 = array[end];

            if(windowMap.containsKey(s1)) {
                Integer count1 = windowMap.get(s1);
                windowMap.put(s1, ++count1);
            }
            else {
                windowMap.put(s1, 1);
            }

            if(windowMap.size() == 3) {
                count += ((s.length()-1) - end +1);
                while(true) {
                    String s2 = array[start];
                    Integer count2  = windowMap.get(s2);
                    count2 -= 1;
                    if(count2 == 0){
                        start = start+1;
                        windowMap.remove(s2);
                        break;
                    }
                    else {
                        count++;
                        start += 1;
                        windowMap.put(s2, count2);
                    }
                }
            }
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "abcabc";
        System.out.println(numberOfSubString(s1));

        String s2 = "aaacb";
        System.out.println(numberOfSubString(s2));

        String s3 = "abc";
        System.out.println(numberOfSubString(s3));
    }

}
