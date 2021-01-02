package ds_general;

public class MergeTwoArray {

    private static int[] returnTwoMergedArray(int[] arr1, int[] arr2) {

        int[] arr3 = new int[arr1.length+arr2.length];

        int ptr1 = 0;
        int ptr2 = 0;
        int i =0;
        for (i=0;i<arr3.length;i++) {

            int a = ptr1 < arr1.length ? arr1[ptr1] : -1;
            int b = ptr2 < arr2.length ? arr2[ptr2] : -1;

            if (a == -1 || b == -1) {
                break;
            }


            if (a>b) {
                arr3[i] = b;
                ptr2 += 1;
            }
            else if (a<b) {
                arr3[i] = a;
                ptr1 += 1;
            }
            else {
                arr3[i] = a;
                arr3[i+1] = a;
                i = i+2;
                ptr1 += 1;
                ptr2 += 1;
            }
        }

        if (ptr2 < arr2.length){
            for (;i<arr3.length;i++) {
                arr3[i] = arr2[ptr2++];
            }
        }
        else if(ptr1 < arr1.length) {
            for (;i<arr3.length;i++) {
                arr3[i] = arr1[ptr1++];
            }
        }

        return arr3;
    }

    public static void main(String[] args) {

        int[] a1 ={1,3,5,7,9};
        int[] a2 = {2,4,6,8,10};

        int[] result = returnTwoMergedArray(a1, a2);
        System.out.println();
        for (Integer val : result) {
            System.out.print(val+" ");
        }

        int[] a3 ={1,3,5,7,9};
        int[] a4 = {2,4,6};

        int[] result_1 = returnTwoMergedArray(a3, a4);
        System.out.println();
        for (Integer val : result_1) {
            System.out.print(val+" ");
        }
    }
}
