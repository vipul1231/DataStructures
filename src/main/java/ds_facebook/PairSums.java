package ds_facebook;

import java.util.Scanner;

public class PairSums {


    static int numberOfWays(int[] arr, int k) {
        int count =0;
        for(int i=0;i<arr.length;i++) {

            for(int j=i+1;j<arr.length;j++) {
                int num_1 = arr[i];
                int num_2 = arr[j];
                if(num_1+num_2 == k) {
                    System.out.println(num_1+","+num_2);
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] array = new int[number];
        for(int i=0;i<number;i++) {
            array[i] = scanner.nextInt();
        }
        int result = numberOfWays(array, sum);
        System.out.println(result);
        scanner.close();
    }
}
