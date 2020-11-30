package ds_facebook;

import java.util.Scanner;

public class RepeatedString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Long letter = Long.parseLong(scanner.nextLine());

        int numLetters = input.length();

        int numOfAChar = 0;
        for(int i=0;i<numLetters;i++) {
            if(input.charAt(i) == 'a') {
                numOfAChar += 1;
            }
        }

        Long remainder = letter % numLetters;
        Long residue = letter - remainder;
        Long firstChar = (residue/numLetters) * numOfAChar;

        for(int i=0;i<remainder;i++) {
            if(input.charAt(i) == 'a') {
                firstChar = firstChar + 1;
            }
        }

        System.out.println(firstChar);
        scanner.close();
    }
}
