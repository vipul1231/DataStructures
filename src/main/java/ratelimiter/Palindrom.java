package ratelimiter;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

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

        CopyOnWriteArrayList cpy = new CopyOnWriteArrayList();

        cpy.add(1);

        cpy.add(2);

        Iterator iter = cpy.iterator();

        while (iter.hasNext()) {

            Object i1 = iter.next();
            System.out.println(i1);
            if(i1.equals(1)) {
                cpy.add(4);
            }
        }

        System.out.println(cpy);
    }


}
