package ds_facebook;

import java.util.Scanner;

public class BinaryAddition {

    private static void printBinaryCombination(int[] input, int carry, int pos) {

        if(input[pos] == 0 && carry == 1) {
            input[pos] = 1;
            pos = input.length-1;
            carry = 0;
            displayArray(input);
            return;
        }
        else if(input[pos] == 1 && carry == 1){
            input[pos] = 0;
            printBinaryCombination(input, 1, --pos);
            return;
        }

        for(double j=Math.pow(2,input.length)-1;j>0;j--) {
            if(input[pos] == 0) {
                input[pos] = 1;
                displayArray(input);
            }
            else {
                input[pos] = 0;
                printBinaryCombination(input, 1, pos-1);
            }
        }
    }

    private static void displayArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        printBinaryCombination(new int[number], 0, number-1);
    }
}
