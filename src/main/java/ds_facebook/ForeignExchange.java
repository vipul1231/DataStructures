package ds_facebook;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ForeignExchange {

    static void canGetExactChange(int targetMoney, int[] denominations, int index) {

        if (index < 0){
            return;
        }
        int currency = denominations[index];

        if(currency <= targetMoney) {
           int value = targetMoney % currency;
           if (value == 0){
               denominations[index] = 0;
               return;
           }
           denominations[index] = value;
           targetMoney = value;
           canGetExactChange(targetMoney, denominations, --index);
        }
        else {
            canGetExactChange(targetMoney, denominations, --index);
        }
    }

    static boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        Arrays.sort(denominations);
        canGetExactChange(targetMoney, denominations, denominations.length-1);

        for (int denomination : denominations) {
            if (denomination == 0) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int[] denomination  = Stream.of(array).mapToInt(Integer::parseInt).toArray();
        int targetMoney = Integer.parseInt(scanner.nextLine());
        System.out.println(canGetExactChange(targetMoney, denomination));
    }
}
