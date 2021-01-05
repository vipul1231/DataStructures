package ds_facebook;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Change in a Foreign Currency
 * You likely know that different currencies have coins and bills of different denominations. In some currencies, it's actually impossible to receive change for a given amount of money. For example, Canada has given up the 1-cent penny. If you're owed 94 cents in Canada, a shopkeeper will graciously supply you with 95 cents instead since there exists a 5-cent coin.
 * Given a list of the available denominations, determine if it's possible to receive exact change for an amount of money targetMoney. Both the denominations and target amount will be given in generic units of that currency.

 */
public class ForeignExchange {


    static int targetMoney = 0;
    /*static void canGetExactChange(int t, int[] denominations, int index) {

        if (index < 0){
            return;
        }
        int currency = denominations[index];

        if(currency <= t) {
            int value = t % currency;
            int v2 = targetMoney % currency;
            if (value == 0){
                denominations[index] = 0;
                return;
            }
            else if(v2 == 0){
                denominations[index] = 0;
                return;
            }
           denominations[index] = value;
           t = value;
           canGetExactChange(t, denominations, --index);
        }
        else {
            canGetExactChange(t, denominations, --index);
        }
    }*/

    private static boolean canGetExactChange(int target, List<Integer> validDenom, int carry, int index) {

        if (index == -1) {
            return false;
        }
        Integer v = validDenom.get(index);
        int v1 = carry % v;

        if (v1 == 0) {
            validDenom.set(index, 0);
            return true;
        }
        else if(target%v == 0) {
            validDenom.set(index, 0);
            return true;
        }
        else {
            carry = v1;
        }
        return canGetExactChange(target, validDenom, carry, --index);
    }

    static boolean canGetExactChange(int t, int[] denominations) {
        // Write your code here
        Arrays.sort(denominations);
        targetMoney = t;
        List<Integer> denomination = Arrays.stream(denominations).boxed().filter(i -> i <= t).collect(Collectors.toList());

        for (int i=denomination.size()-1;i>=1;i--) {
            boolean value = canGetExactChange(t, denomination, t, i);
            if (value) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] array_1 = {5,10,25,100,200};
        System.out.println(canGetExactChange(94, array_1));

        int[] array_2 = {5,3};
        System.out.println(canGetExactChange(12, array_2));

        int[] array_3 = {6,9,10,43,78,93};
        System.out.println(canGetExactChange(121, array_3));

        int[] array_4 = {6,9,10,43,78,93};
        System.out.println(canGetExactChange(47, array_4));
    }
}
