package ds_general;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubString {

    public static String longestPalindrome(String s) {
        String[] arr1 = s.split("");

        if (arr1.length == 1) {
            return s;
        }

        int length = 0;
        String longestPalindrome = null;
        StringBuilder stringBuilder = new StringBuilder();


        for (int i=0;i<arr1.length;i++) {
            String s1 = arr1[i];
            stringBuilder.append(s1);

            if (longestPalindrome == null) {
                longestPalindrome = stringBuilder.toString();
                length = longestPalindrome.length();
            }
            int left = i-1;
            int right = i+1;
            while (left >= 0 /*&& right <=arr1.length-1*/) {
                stringBuilder.insert(0, arr1[left]);
                StringBuilder stringBuilder1 = new StringBuilder(stringBuilder.toString());
                if(stringBuilder.toString().equals(stringBuilder1.reverse().toString()) && stringBuilder.toString().length() > length) {
                    longestPalindrome = stringBuilder.toString();
                    length = longestPalindrome.length();
                }
                if (right <= arr1.length-1)
                stringBuilder.insert(stringBuilder.length(), arr1[right]);
                if (right == arr1.length) {
                    break;
                }
                left = left -1;
                right = right +1;
                if(stringBuilder.toString().equals(stringBuilder.reverse().toString()) && stringBuilder.toString().length() > length) {
                    longestPalindrome = stringBuilder.toString();
                    length = longestPalindrome.length();
                }
            }
            stringBuilder.delete(0, stringBuilder.toString().length());
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("bcbad"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("bcdaa"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("xyztarratabc"));
    }

}
