package ds_facebook;

import java.util.Scanner;

public class MatchingPairs {

    static int matchingPairs(String s, String t) {
        // Write your code here

        int count =0;
        boolean swapFound = false;
        for(int i=0;i<s.length();i++) {
            char sa = s.charAt(i);
            char ta = t.charAt(i);

            if (sa == ta) {
                count++;
            }
            else {
                int index_1  =s.indexOf(ta);
                int index_2 = t.indexOf(sa);
                if (index_1 != -1 && index_1 == index_2 && !swapFound) {
                    count = count + 2;
                    swapFound = true;
                }
            }
        }

        if(count == s.length() && !swapFound) {
            count = count - 2;
        }
        else if((count == s.length()-1) && !swapFound){
            count = count - 1;
        }

        return count;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%d",matchingPairs(scanner.nextLine(), scanner.nextLine()));
        scanner.close();
    }
}
