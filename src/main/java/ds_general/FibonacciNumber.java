package ds_general;

public class FibonacciNumber {

    static int fibonacciSum(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        } else {
            return fibonacciSum(number - 1) + fibonacciSum(number - 2);
        }
    }

    static int fibonacciSumDpProblem(int number, int[] list) {

        if (number ==0) {
            list[number] = 0;
            return list[number];
        }
        if (number == 1) {
            list[number] = 1;
            return list[number];
        }

        if (number < list.length && list[number] != 0) {
            return list[number];
        }
        else {
            list[number] = fibonacciSumDpProblem(number-1, list) + fibonacciSumDpProblem(number-2, list);
        }
        return list[number];
    }

    public static void main(String[] args) {

        System.out.println(fibonacciSum(7));
        int[] dpArray = new int[100];
        System.out.println(fibonacciSumDpProblem(7, dpArray));
    }
}
