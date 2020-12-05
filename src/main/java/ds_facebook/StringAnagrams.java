package ds_facebook;

import java.util.Scanner;

public class StringAnagrams {

    public static void permutation(String input, int left, int right) {
        if(left == right) {
            System.out.println(input);
        }
        for(int i=left;i<=right;i++) {
            input= swap(input, left, i);
            System.out.println("Value_1: "+input + ", left: "+left+", i:"+i);
            permutation(input, left+1, right);
            //swap(input,value, )
            input = swap(input, left, i);
            System.out.println("Value_2: "+input+", left: "+left+", i:"+i);
        }
    }

    public static String swap(String input, int i, int j) {
        char[] charArray = input.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        permutation(input, 0, input.length() - 1);
        scanner.close();
    }
}
