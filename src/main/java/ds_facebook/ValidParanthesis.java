package ds_facebook;

import java.util.Collections;
import java.util.Stack;

public class ValidParanthesis {


    public static int longestValidParentheses(String s) {
        int length = 0;
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '('){
                charStack.push(s.charAt(i));
                indexStack.push(i);
            }

            else {
                if (charStack.isEmpty()) {
                    indexStack.push(i);
                }
                else {
                    charStack.pop();
                    indexStack.pop();
                    length = Math.max(i-indexStack.peek(), length);
                }
            }
        }
        System.out.println(length);
        return length;
    }

    static int findMaxLen(String s) {
        String[] array = s.split("");
        int length = 0;
        Stack<Integer> dpStack = new Stack<>();
        for (String item : array) {
            if (item.equals("(")) {
                dpStack.push(1);
            } else {
                //Handle edge case
                if (dpStack.isEmpty()) {
                    continue;
                }
                if (dpStack.peek() != 1) {
                    int value = dpStack.pop();
                    if (!dpStack.isEmpty() && dpStack.peek() == 1) {
                        dpStack.pop();
                        dpStack.push(value + 2);
                    } else {
                        if (value != -1)
                            dpStack.push(value);
                        dpStack.push(-1);
                    }
                } else {
                    dpStack.pop();
                    if (dpStack.size() > 0 && dpStack.peek() > 1) {
                        int val = dpStack.pop();
                        dpStack.push(val + 2);
                    } else {
                        dpStack.push(2);
                    }
                }
            }
        }
        System.out.println(dpStack);
        return Collections.max(dpStack);
    }


    public static void main(String[] args) {
        String s1 = "(()()";
        longestValidParentheses(s1);

        String s2 = "(()(((()";
        longestValidParentheses(s2);

        String s3 = "(())))()";
        longestValidParentheses(s3);

        String s4 = "(()())))()";
        longestValidParentheses(s4);

        String s5 = ")()())";
        System.out.println(longestValidParentheses(s5));
    }
}
