package ds_general;


/**
 * This will help you understand recursion.
 */
public class UnderstandingRecursion {

    private static int recursiveTracePath(int n, int m, int result) {

        if (n == 1 || m == 1) {
            return 1;
        }
        else {
            result+= recursiveTracePath(n-1, m, result) + recursiveTracePath(n, m-1, result);
        }
        return result;
    }


    static int steps = 0;
    private static int power_1(int a, int b) {
        steps++;
        if (b==0) {
            return 1;
        }

        if (b%2 == 0) {
            return power_1(a*a, b/2);
        }
        else {
            return a*power_1(a, b-1);
        }
    }

    private static int power(int a, int b) {
        steps++;
        if (b == 1) {
            return a;
        }

        a = a * power(a, --b);
        return a;
    }

    private static int printSumOfNumberInArray(int number) {
        if (number == 1) {
            return number;
        }

        number += printSumOfNumberInArray(--number);
        return number;
    }

    public static void main(String[] args) {
        //1+2+3+4+5 = 15
        /*System.out.println(printSumOfNumberInArray(5));
        System.out.println(power(2, 3));
        System.out.println(power(3, 4));
        System.out.println(power_1(3, 4));*/
        /*System.out.println(power_1(3, 10000));
        System.out.println(steps);
        steps = 0;
        System.out.println(power(3, 10000));
        System.out.println(steps);*/

        System.out.println(recursiveTracePath(4,4, 0));
    }
}
