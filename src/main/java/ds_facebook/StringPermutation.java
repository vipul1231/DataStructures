package ds_facebook;

import java.util.*;

public class StringPermutation {

    /**
     *
     * @param str
     * @return
     */
    private static Set<String> permute_1 (String str) {

        Set<String> permutations = new HashSet<>();
        // create a set to avoid duplicate permutation
        // check if string is null
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            // terminating condition for recursion
            permutations.add("");
            return permutations;
        }

        // get the first character
        char first = str.charAt(0);

        // get the remaining substring
        String sub = str.substring(1);

        // make recursive call to getPermutation()
        Set<String> words = permute_1(sub);

        // access each element from words
        System.out.println(words);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){

                // insert the permutation to the set
                permutations.add(strNew.substring(0, i) + first + strNew.substring(i));
            }
        }
        return permutations;
    }


    private static void permutation(String[] input, int left, int right) {

        if (left == right) {
            displayArray(input);
        }


        int start = 0;
        for (int i=left;i<input.length;i++) {
            swap(input, left, i);
            permutation(input,left+1, right);
            //displayArray(input);
            swap(input, left, i);
        }
    }

    private static void displayArray(String[] array) {
        for (String j : array) {
            System.out.print(j+" ");
        }
        System.out.println();
    }

    private static void swap(String[] s1, int i, int j) {
        String temp = s1[i];
        s1[i] = s1[j];
        s1[j] = temp;
    }

    private static void permutation(String input) {
        permutation(input.split(""),0, input.length());
    }

    public static void main(String[] args) {
        permutation("ABC");
        System.out.println(permute_1("ABC"));
        //System.out.println(permutations);
    }
}
