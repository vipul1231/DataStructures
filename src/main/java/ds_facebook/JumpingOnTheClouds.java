package ds_facebook;

import java.util.Scanner;

public class JumpingOnTheClouds {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        String[] inputArray = scanner.nextLine().split(" ");

        int jump = 0;
        int start = 0;
        while (start < (inputArray.length-1)) {
            if((start+2 <= inputArray.length-1) && inputArray[start+2].equals("0")) {
                jump += 1;
                start += 2;
            }
            else {
                jump += 1;
                start = start + 1;
            }
        }
        System.out.println(jump);
        scanner.close();
    }
}
