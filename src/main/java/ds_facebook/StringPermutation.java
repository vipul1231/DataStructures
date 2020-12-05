package ds_facebook;

import java.util.Scanner;

public class StringPermutation {

    private static void permutation(String input, String prefix) {
        if(input.length() == 0) {
            System.out.println(prefix);
        }
        else {
            for(int i=0;i < input.length();i++) {
                String rem = input.substring(0, i) + input.substring(i+1);
                //System.out.println("Remaining: "+rem+", PREFIX: "+prefix+input.charAt(i));
                permutation(rem, prefix+input.charAt(i));
            }
        }
    }

    private static void permutation(String input) {
        permutation(input,"");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        permutation(scanner.nextLine());
        scanner.close();
    }
}
