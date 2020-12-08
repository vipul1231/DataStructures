package ds_facebook;

import java.util.Scanner;

public class RotationalCipher {

    static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder stringBuilder = new StringBuilder();

        int rotationFactorAlphabet = 0;
        if(rotationFactor > 26) {
            rotationFactorAlphabet = rotationFactor % 26;
        }
        else {
            rotationFactorAlphabet = rotationFactor;
        }
        int rotationFactorNumber = 0;
        if (rotationFactor > 10) {
            rotationFactorNumber = rotationFactor % 10;
        }
        else {
            rotationFactorNumber = rotationFactor;
        }

        for(int i=0;i<input.length();i++) {
            int value = input.charAt(i);

            if(value<=90 && value>=65) {
                int total = value + rotationFactorAlphabet;
                if(total > 90) {
                    int less = total - 90;
                    total = 65 + (less-1);
                }
                System.out.print((char) total);
                stringBuilder.append((char) total);
            }
            else if(value >= 97 && value <=122) {
                int total = value + rotationFactorAlphabet;
                if(total > 122) {
                    int less = total - 122;
                    total = 97 + (less-1);
                }
                System.out.print((char) total);
                stringBuilder.append((char) total);
            }
            else if(value >= 48 && value <=57){

                int total = value + rotationFactorNumber;
                if(total > 57) {
                    int less = total - 57;
                    total = 48 + (less -1);
                }
                System.out.print((char) total);
                stringBuilder.append((char) total);
            }
            else {
                System.out.print((char) value);
                stringBuilder.append((char) value);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        rotationalCipher(strings[0], Integer.parseInt(strings[1]));
        scanner.close();
    }
}
