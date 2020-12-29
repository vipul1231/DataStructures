package ds_general;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        String[] array = s.split("");

        int length = 0;
        int start = 0;
        int end = 0;
        boolean fd = false;

        if (array.length == 1 && array[0].equals(" ")) {
            return 1;
        }
        else if (array.length == 1 && array[0].equals("")) {
            return 0;
        }
        else if (array.length == 1) {
            return 1;
        }

        Set<String> unique = new HashSet<>();
        while (end<=array.length-1 && start <= array.length -1) {

            for (int i = end; i<array.length;i++) {
                String s1 = array[i];
                //this mean it contains duplicate
                if (unique.contains(s1)) {
                    end = i;
                    fd = true;
                    if (unique.size() > length) {
                        length = unique.size();
                        //System.out.println(s.substring(start, end));
                    }
                    break;
                }
                else {
                    end = i;
                    unique.add(s1);
                    if (unique.size() > length) {
                        length = unique.size();
                        //System.out.println(s.substring(start, end+1));
                    }
                }
            }

            if (fd) {
                for (int i=start;i<array.length;i++) {
                    String s1 = array[i];

                    if (s1.contains(array[end])) {
                        unique.remove(s1);
                        start = i+1;
                        if (start < array.length -1 && array[start].equals(array[end])) {
                            unique.add(array[end]);
                            end = end +1;
                        }
                        fd = false;
                        break;
                    }
                    else {
                        unique.remove(s1);
                    }
                }
            }
        }

        return length;
    }

    public static void main(String[] args) {
        String a = "AERRRRRRRR";
        String a1 = "bb";
        String a2 = "bbbbbbb";
        String a3 = "pwwkew";
        String a4 = "ABXZRTBA";
        String a6 = "ABERTYUAQWETYUIEOPQRSZT";
        String a5 = "";
        String a7 = "C";
        String a8 = "ASERTTTTTTTTTYUWIOPNBV";

        System.out.println(lengthOfLongestSubstring(a1));
        System.out.println(lengthOfLongestSubstring(a2));
        System.out.println(lengthOfLongestSubstring(a3));
        System.out.println(lengthOfLongestSubstring(a4));
        System.out.println(lengthOfLongestSubstring(a5));
        System.out.println(lengthOfLongestSubstring(a6));
        System.out.println(lengthOfLongestSubstring(a7));
        System.out.println(lengthOfLongestSubstring(a8));
    }
}
