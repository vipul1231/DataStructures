package ds_facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NewYearChaos {

    private static void guessBribes(int[] inputArray, Map<Integer,Integer> positionMap) {
        int bribe = 0;
        boolean tooChaotic = false;
        for (int i = 0; i < inputArray.length; i++) {
            int idx = inputArray[i];
            if (idx == (i+1) || idx < (i+1)) {
                continue;
            }
            if(idx > (i+1) && idx - (i+1) <=2) {
                bribe += idx - (i+1);
            }
            else {
                tooChaotic = true;
                System.out.println("Too chaotic");
                break;
            }
        }

        if (!tooChaotic)
        System.out.println(bribe);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTest = scanner.nextInt();

        for(int i=0;i<noOfTest;i++) {
            Map<Integer, Integer> positionInteger = new HashMap<>();
            int inputLength = scanner.nextInt();
            int[] array = new int[inputLength];
            for(int j=0;j<inputLength;j++) {
                array[j] = scanner.nextInt();
                positionInteger.put(array[j], j+1);
            }
            guessBribes(array, positionInteger);
        }
        scanner.close();
    }
}
