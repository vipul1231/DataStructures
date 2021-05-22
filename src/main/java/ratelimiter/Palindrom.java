package ratelimiter;

public class Palindrom {

    public static boolean isPalindrom(String value) {
        
        int start = 0, end = value.length()-1;
        while (start == end || start < end) {
            if (value.charAt(start) == value.charAt(end)) {
                start++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String arr = "aabbaa";
        System.out.println(isPalindrom(arr));

        String arr_1 = "aabaa";
        System.out.println(isPalindrom(arr_1));

        String arr_2 = "aabac";
        System.out.println(isPalindrom(arr_2));

        String arr_3 = "aabbbcbbdaa";
        System.out.println(isPalindrom(arr_3));
    }
}
