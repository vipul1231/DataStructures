package ratelimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Anagrams {

    public static boolean isAnagram(String s1, String s2) {

        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (int i=0;i<s1.length();i++) {
            Integer value = characterIntegerMap.putIfAbsent(s1.charAt(i), 1);
            if (value != null) {
                characterIntegerMap.put(s1.charAt(i), ++value);
            }
        }

        for (int i=0;i<s2.length();i++) {
            Integer value = characterIntegerMap.get(s2.charAt(i));
            if (value == null) {
                return false;
            }
            else {
                value = value -1;
                if (value == 0)
                characterIntegerMap.remove(s2.charAt(i));
                else characterIntegerMap.put(s2.charAt(i), value);
            }
        }

        return characterIntegerMap.size() == 0;
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("abc","cbag"));

        String s1 = "vipul";
        String s2 = "vipul";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
