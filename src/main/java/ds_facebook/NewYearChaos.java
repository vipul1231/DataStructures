package ds_facebook;

import java.util.*;

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

    private static void guessBribes_1(int[] array, Map<Integer, Integer> positionMap) {
        int bribe = 0;
        for(int i=array.length-1;i>=1;i--) {
            int value = array[i];
            int exactPosition = positionMap.get(i);

            if ((i) == exactPosition) {
                continue;
            }
            int remaining = Math.abs(i-exactPosition);
            if (remaining > 2) {
                System.out.println("To chaotic");
                break;
            }
            else if (remaining == 2){
                int temp_1 = array[i];
                int temp_2 = array[i-1];
                array[i] = i;
                array[exactPosition] = temp_2;
                array[i-1] = temp_1;
                //update the indexes
                positionMap.put(temp_1, i-1);
                positionMap.put(temp_2, exactPosition);
                positionMap.put(array[i], i);
                bribe += 2;
            }
            else {
                positionMap.put(array[i], i-1);
                positionMap.put(array[i-1], i);
                int temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
            }
        }
        System.out.println(bribe);
    }

    private static void guessBribes_3(int[] array) {
        //Calculate for two swap position
        int one = 1, two = 2, three = 3;
        int bribe = 0;
        for(int i=0;i<array.length;i++) {
            if (array[i] == one) {
                one = two;
                two = three;
                three++;
            }
            else if(array[i] == two) {
                ++bribe;
                two = three;
                ++three;
            }
            else if(array[i] == three) {
                bribe += 2;
                ++three;
            }
            else {
                System.out.println("To chaotic");
                return;
            }
        }

        System.out.println(bribe);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTest = scanner.nextInt();

        for(int i=0;i<noOfTest;i++) {
            int inputLength = scanner.nextInt();
            int[] array = new int[inputLength];
            for(int j=0;j<array.length;j++) {
                array[j] = scanner.nextInt();
            }
            guessBribes_3(array);
        }
        scanner.close();
    }
}
