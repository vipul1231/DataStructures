package ds_facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaleByMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        Map<Integer, Integer> socksPair = new HashMap<>();

        int numberOfPair = 0;
        for(int i=0;i<input;i++) {
            int color = scanner.nextInt();
            Integer number = socksPair.get(color);
            if(number == null) {
                socksPair.put(color, 1);
            }
            else {
                if(((number +1) % 2) == 0) {
                    numberOfPair += 1;
                    socksPair.put(color, ++number);
                }
                else {
                    socksPair.put(color, ++number);
                }
            }
        }

        //System.out.println(socksPair);
        System.out.println(numberOfPair);

        scanner.close();
    }
}
