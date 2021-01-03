package ds_general;

public class MergeTwoArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr3 = new int[nums1.length+nums2.length];

        int ptr1 = 0;
        int ptr2 = 0;
        int i =0, a =0, b=0;
        for (i=0;i<arr3.length;i++) {

            if (ptr1 < nums1.length) {
                a = nums1[ptr1];
            }
            else {
                break;
            }
            if (ptr2 < nums2.length) {
                b = nums2[ptr2];
            }
            else {
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
                if (i < arr3.length-1) {
                    arr3[i] = a;
                    arr3[i+1] = a;
                    i = i+1;
                    ptr1 += 1;
                    ptr2 += 1;
                }
            }
        }

        if (ptr2 < nums2.length){
            for (;i<arr3.length;i++) {
                arr3[i] = nums2[ptr2++];
            }
        }
        else if(ptr1 < nums1.length) {
            for (;i<arr3.length;i++) {
                arr3[i] = nums1[ptr1++];
            }
        }

        if (arr3.length == 1) {
            return arr3[0];
        }

        int mid = arr3.length/2;
        double result = 0;
        if (arr3.length % 2 == 0) {
            result = (double) (arr3[mid-1] + arr3[mid])/2;
            return result;
        }else {
            return arr3[mid];
        }
    }


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

        /*int[] a1 ={1,3,5,7,9};
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


        int[] a5 ={1,3};
        int[] a6 = {2};*/
       /* int[] a5 ={1,3};
        int[] a6 = {2};
        System.out.println(findMedianSortedArrays(a5,a6));

        int[] a7 ={1,2};
        int[] a8 = {3,4};
        System.out.println(findMedianSortedArrays(a7,a8));*/

        int[] a9 ={1,1};
        int[] a10 = {1,1};
        System.out.println(findMedianSortedArrays(a9,a10));
    }
}
