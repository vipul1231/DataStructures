package ds_facebook;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class QueueRemoval {

    static int[] findPositions(int[] arr, int x) {
        // Write your code here
        int[] result = new int[x];
        int resultCount = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();


        for (int i=0;i<x;i++) {
            indexMap.clear();
            for(int k=0;k<arr.length;k++) {
                if(!indexMap.containsKey(arr[k])) {
                    indexMap.put(arr[k], k+1);
                }
            }
            //Step 1;
            int max = 0;
            int index = 0;
            List<Integer> arrayList = new ArrayList<>();
            if(x > arr.length) {
                x = arr.length;
            }
            for (int j=0;j<x;j++) {
                if(max < arr[j]) {
                    max = arr[j];
                    index = j;
                }
                arrayList.add(arr[j]);
            }
            arrayList.remove(index);
            result[resultCount] = indexMap.get(max);
            resultCount++;
            int[] leftArray = arrayList.stream().mapToInt(k -> Math.max(k - 1, 0)).toArray();
            int[] finalArray = new int[arr.length-1];
            //int[] array = Arrays.copyOfRange(arr, x,arr.length);
            int length = arr.length - x;
            System.arraycopy(arr, x, finalArray,0, length);
            System.arraycopy(leftArray,0, finalArray, length, finalArray.length-1);
            arr = finalArray;
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int items = scanner.nextInt();
        int iter = scanner.nextInt();
        int[] array = new int[items];
        for(int i=0;i<items;i++) {
            array[i] = scanner.nextInt();
        }
        int[] result = findPositions(array, iter);

        for (int i=0;i<result.length;i++) {
            System.out.print(result[i]+" ");
        }

        scanner.close();
    }
}
