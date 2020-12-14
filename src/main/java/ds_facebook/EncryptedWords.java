package ds_facebook;

import java.util.Scanner;

public class EncryptedWords {

    static void findEncryptedWord(String s, StringBuilder match) {
        int middle = s.length()/2;
        if(s.length() == 1) {
            match.append(s);
            return;
        }
        if(s.length()%2 == 0) {
            match.append(s.charAt(middle - 1));
            if(0 != middle-1)
            findEncryptedWord(s.substring(0,middle-1), match);
            findEncryptedWord(s.substring(middle),match);
        }
        else {
            match.append(s.charAt(middle));
            findEncryptedWord(s.substring(0,middle), match);
            findEncryptedWord(s.substring(middle+1),match);
        }
    }


    static String findEncryptedWord(String s) {
        // Write your code here
        StringBuilder stringBuilder = new StringBuilder();
        findEncryptedWord(s, stringBuilder);
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(findEncryptedWord(scanner.nextLine()));
        scanner.close();
    }
}
