package ds_general;

import java.util.HashMap;

public class LongestArithmeticSubSequence {

    public static int longestArithSeqLength(int[] A) {

        HashMap<Integer, Integer>[] hashMaps = new HashMap[A.length];
        int maxValue = 0;
        for (int i=0;i<A.length;i++) {
            hashMaps[i] = new HashMap<>();
            for (int j=0;j<i;j++) {
                int diff = A[j] - A[i];
                int value = hashMaps[j].getOrDefault(diff, 0) +1;
                hashMaps[i].put(diff, value);
                maxValue = Math.max(maxValue, hashMaps[i].get(diff));
            }
        }

        return maxValue+1;
    }

    static void displayArray(int[] a) {
        System.out.println();
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {20,1,15,3,10,5,8};
        System.out.println(longestArithSeqLength(a));

        int[] a1 = {3, 6, 9, 12};
        System.out.println(longestArithSeqLength(a1));

        int[] a2 = {24,13,1,100,0,94,3,0,3};
        System.out.println(longestArithSeqLength(a2));
    }
}
