package ds_facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwaps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number+1];
        Map<Integer, Integer> numberToPositionMap = new HashMap<>();
        Map<Integer, Integer> positionToNumberMap = new HashMap<>();
        for(int i=1;i<number+1;i++) {
            array[i] = scanner.nextInt();
            numberToPositionMap.put(array[i], i);
            positionToNumberMap.put(i, array[i]);
        }

        //System.out.println(numberToPositionMap);
        //System.out.println(positionToNumberMap);
        int count = 0;
        for(int j=1;j<array.length;j++) {
            int a = array[j];
            if(a == j) {
                continue;
            }
            int b = array[a];

            if(b == j) {
                continue;
            }

            int c = numberToPositionMap.get(j);
            int swap = array[c];
            array[c] = array[a];
            array[a] = swap;
            numberToPositionMap.put(array[a], a);
            numberToPositionMap.put(array[c], c);
            count++;
        }

        /*for(int i=1;i<array.length;i++) {
            System.out.print(array[i]+" "+i+"\n");
        }*/

        for( int i =1;i<array.length;i++) {
            if(array[i] != i) {
                int number_1 = array[i];
                //swap
                int temp = array[i];
                array[i] = array[number_1];
                array[number_1] = temp;
                count++;
            }
        }

        System.out.println(count);
        scanner.close();
    }
}
