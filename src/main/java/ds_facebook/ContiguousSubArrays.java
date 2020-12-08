package ds_facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContiguousSubArrays {

    static int[] countSubArray(int[] arr) {
        List<Integer> count = new ArrayList<>();
        int[] array = new int[arr.length];
        Integer match = 0;
        for(int i=0;i<arr.length;i++) {
            recursiveCheckForPossibility(arr, i, i, true, false, count);
            recursiveCheckForPossibility(arr, i+1, i,false,true, count);
        }
        return count.stream().mapToInt(i -> i).toArray();
    }

    static void recursiveCheckForPossibility(int[] arr, int index, int start, boolean left, boolean right, List<Integer> countArray) {

        if(countArray.size() <= index && left) {
            countArray.add(index, 1);
            if (index == 0) {
                return;
            }
            else if (arr[index] > arr[start]) {
                return;
            }
        }
        else {
            if(index >=0 && index < arr.length && arr[index] < arr[start]) {
                Integer countList = countArray.get(start);
                countArray.set(start, ++countList);
            }
            else {
                return;
            }
        }
        if(left) {
            recursiveCheckForPossibility(arr,--index, start, left, right, countArray);
        }
        else if(right) {
            recursiveCheckForPossibility(arr, ++index, start, left, right, countArray);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];
        for (int i=0;i<number;i++) {
            array[i] = scanner.nextInt();
        }
        int[] result = countSubArray(array);

        for (int value : result) {
            System.out.print(value + " ");
        }

        scanner.close();
    }
}
