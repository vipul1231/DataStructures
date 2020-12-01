package ds_facebook;

import java.util.Scanner;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLen = scanner.nextInt();
        int numberOfRotation = scanner.nextInt();
        int[] array = new int[inputLen];
        for(int i=0;i<inputLen;i++) {
            array[i] = scanner.nextInt();
        }

        int start = numberOfRotation % inputLen;

        for (int i=0;i<inputLen;i++) {
            System.out.print(array[(i+start) % inputLen] + " ");
        }

        scanner.close();
    }
}
