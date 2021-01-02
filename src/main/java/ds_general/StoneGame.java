package ds_general;

import java.util.Arrays;

public class StoneGame {

    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {

        int[][] sumArray = new int[aliceValues.length][3];
        for (int i=0;i<aliceValues.length;i++) {
            sumArray[i][0] = aliceValues[i] + bobValues[i];
            sumArray[i][1] = aliceValues[i];
            sumArray[i][2] = bobValues[i];
        }
        Arrays.sort(sumArray, (a, b) -> Double.compare(b[0], a[0]));

        int aliceValue =0, bobValue =0;

        for (int i=0;i<aliceValues.length;i++) {
            if (i%2 == 1) {
                bobValue += sumArray[i][2];
            }
            else {
                aliceValue += sumArray[i][1];
            }
        }

        return Integer.compare(aliceValue, bobValue);
    }


    public static void main(String[] args) {
        int[] a = {1,3};
        int[] b = {2,1};
        System.out.println(stoneGameVI(a,b));
        int[] a1 = {1,2};
        int[] b1 = {3,1};
        System.out.println(stoneGameVI(a1,b1));
        int[] a2 = {2,4,3};
        int[] b2 = {1,6,7};
        System.out.println(stoneGameVI(a2,b2));

        int[] a3 = {8};
        int[] b3 = {8};
        System.out.println(stoneGameVI(a3,b3));
    }
}
