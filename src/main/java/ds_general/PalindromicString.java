package ds_general;

import java.util.ArrayList;
import java.util.List;

public class PalindromicString {

    private static boolean isPalindrom(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder = stringBuilder.reverse();

        if (s.equals(stringBuilder.toString())) {
            return true;
        }
        return false;
    }

    public static void partition(String s,List<String> temp, List<List<String>> result) {


        for (int i=0;i<s.length();i++) {

            String left = s.substring(0, i+1);
            String right = s.substring(i+1);

            if (isPalindrom(left)) {
                temp.add(left);
                partition(right, temp, result);
                if (right.isEmpty()) {
                    result.add(new ArrayList<>(temp));
                    System.out.println(temp);
                }
                temp.remove(temp.size() -1);
            }
        }
    }


    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        partition("RADAR");
    }
}
