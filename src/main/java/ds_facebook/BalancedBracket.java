package ds_facebook;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {

    static boolean isBalanced(String s) {
        // Write your code here
        String b1="(";
        String b2 =")";

        String b3 = "[";
        String b4 = "]";

        String b5 = "{";
        String b6 = "}";

        Stack<String> stack = new Stack<>();

        String[] inputArray = s.split("");

        for (String s1 : inputArray) {
            if (s1.equals(b1) || s1.equals(b3) || s1.equals(b5)) {
                stack.push(s1);
            } else {
                if (s1.equals(b2)) {
                    try {
                        String topValue = stack.peek();
                        if (topValue.equals(b1)) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                    catch (Exception e) {
                        return false;
                    }
                } else if (s1.equals(b4)) {
                    try {
                        String topValue = stack.peek();
                        if (topValue.equals(b3)) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                    catch (Exception e) {
                        return false;
                    }
                } else if (s1.equals(b6)) {

                    try {
                        String topValue = stack.peek();
                        if (topValue.equals(b5)) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                    catch (Exception e) {
                        return false;
                    }
                }
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isBalanced(scanner.nextLine()));

    }

}
