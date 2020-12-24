package ds_general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAllBooleanCombination {

    static List<List<Integer>> combinations = new ArrayList<>();

    static void printBooleanAddition(int[] arr, int index) {

        if (arr[index] == 0) {
            arr[index] = 1;
            combinations.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
        else {
            arr[index] = 0;
            printBooleanAddition(arr, --index);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[4];
        combinations.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        for (int i=0;i<Math.pow(2, arr.length)-1;i++)
        printBooleanAddition(arr, arr.length-1);
        System.out.println(combinations);
    }
}
