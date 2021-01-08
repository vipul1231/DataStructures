package ds_general;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindDiffInArray {

    public static int search(final List<Integer> A, int B) {

        int p=0;
        for(int i=0;i<A.size()-1;i++) {

            int number = A.get(i);

            if(number == B) {
                return i;
            }

            if(i-1>0 && (A.get(i-1)) < number && number>A.get(i+1)) {
                int found = binarySearch(A, i+1, A.size()-1, B);
                if(found != 0){
                    return found;
                }
                else {
                    return 0;
                }
            }

        }
        return 0;

    }

    private static int binarySearch(List<Integer> A, int si, int ei, int k) {

        int mid = si + (ei - si) / 2;

        if(si >= ei) {
            return -1;
        }


        if(A.get(mid) == k) {
            System.out.println(mid+" "+si+" "+ei);
            return mid;
        }

        if(A.get(mid) < k) {
            System.out.println(mid);
            return binarySearch(A, mid+1, ei, k);
        }
        System.out.println(mid);
        return binarySearch(A, si, mid-1, k);
    }

    public static void main(String[] args) {
        int[] ar = {7,4,5,6,7,0,1,2,3};
        System.out.println(search(Arrays.stream(ar).boxed().collect(Collectors.toList()), 2));
    }
}
