package ds_general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestArithemeticSubSequence {

    public static int longestSubsequence(int[] arr, int difference) {

        Arrays.sort(arr);
        difference = Math.abs(difference);
        List<List<Integer>> longestSubSequence = new ArrayList<>();
        for (int i=0;i<arr.length;i++) {

            int number = arr[i];
            List<Integer> subSequence = new ArrayList<>();
            subSequence.add(number);
            for (int j = i+1;j<arr.length;j++) {
                int next = arr[j];
                if (number + difference == next) {
                    subSequence.add(next);
                    number = next;
                }
                else if(number+difference<next) {
                    break;
                }
            }
            longestSubSequence.add(subSequence);
        }

        int max =0;
        for (List<Integer> sequence : longestSubSequence) {
            int size = sequence.size();
            if (size > max) {
                max = size;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array_1 = {1,5,7,8,5,3,4,2,1};
        int[] array_2 = {1,3,5,7};
        int[] array_3 = {1,2,3,4};
        int[] array_4 = {3,0,-3,4,-4,7,6};

        System.out.println(longestSubsequence(array_1, -2));
        System.out.println(longestSubsequence(array_2, 1));
        System.out.println(longestSubsequence(array_3, 1));
        System.out.println(longestSubsequence(array_4, 3));

    }
}
