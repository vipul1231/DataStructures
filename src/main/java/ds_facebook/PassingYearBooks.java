package ds_facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassingYearBooks {

    public static void findSignatureCount(int[] array) {

        Map<Integer, List<Integer>> mapper = new HashMap<>();
        int group = 2;
        int[] result = new int[array.length];
        for (int i=0;i<array.length;i++) {
            int initialNumber = array[i];

            if(initialNumber-1 == i){
                array[i] = -1;
                continue;
            }
            if(initialNumber < 0) {
                continue;
            }
            List<Integer> groupList = new ArrayList<>();
            groupList.add(initialNumber);
            int number = initialNumber;
            do {
                int nextNumber = array[number - 1];
                groupList.add(nextNumber);
                array[number - 1] = -group;
                number = nextNumber;
            } while (initialNumber != number);
            mapper.put(-group, groupList);
            ++group;
        }

        for (int i=0;i<array.length;i++) {
            int number = array[i];

            if(number == -1) {
                result[i] = 1;
            }
            else {
                List<Integer> groupList = mapper.get(number);
                result[i] = groupList.size()-1;
            }
        }

      display(result);
    }

    private static void display(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arrays_1 = {3, 2, 5, 1, 4, 8, 7, 6};
        int[] arrays_2 = {1, 2};
        int[] arrays_3 = {2, 1};
        int[] arrays_4 = {4, 3, 2, 5, 1};
        findSignatureCount(arrays_1);
        findSignatureCount(arrays_2);
        findSignatureCount(arrays_3);
        findSignatureCount(arrays_4);
    }
}
