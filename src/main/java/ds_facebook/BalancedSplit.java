package ds_facebook;

import java.util.Scanner;
import java.util.stream.Stream;

public class BalancedSplit {

    static boolean balancedSplitExists(int[] arr) {
        // Write your code here
        int leftSum =0, rightSum =0;
        for (int value : arr) {
            leftSum += value;
        }
        for(int i= arr.length-1;i>0;i--) {
            rightSum += arr[i];
            leftSum -= arr[i];

            if(leftSum == rightSum && arr[i-1] < arr[i]) {
                 return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splitArray = scanner.nextLine().split(" ");

        int[] arr = Stream.of(splitArray).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(balancedSplitExists(arr));
        scanner.close();

    }
}
