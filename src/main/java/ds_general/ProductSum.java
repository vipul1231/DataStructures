package ds_general;

public class ProductSum {


    public static int[] productSumWithOutDivision(int[] nums) {

        //record product in left to right traversal.
        int[] arr_1 = new int[nums.length];
        int product = 1;
        for (int i=0;i<nums.length;i++) {
            product = product*nums[i];
            arr_1[i] = product;
        }
        display(arr_1);

        //now traverse back and start recording product in backward fashion.
        product = 1;
        for (int i=nums.length-1;i>=0;i--) {
            //handle the last case of 0 when i-1 will result in Index out of bound.
            if (i==0) {
                arr_1[i] = product;
                continue;
            }
            //always take one less index as it will give product excluding the current of previous number.
            int left = arr_1[i-1];
            //now multiple the left product to the product we are recording on right of the number.
            arr_1[i] = left*product;
            //recalculate the new product.
            product=product*nums[i];
        }
        display(arr_1);
        return arr_1;
    }


    public static int[] productSum(int[] arr) {
        int product = 1;
        int[] result = new int[arr.length];
        for (int i=0;i<arr.length;i++) {
            product *= arr[i];
        }

        for (int i=0;i<arr.length;i++) {
            result[i] = product/arr[i];
        }

        return result;
    }


    public static void display(int[] arr) {
        System.out.println();
        for (Integer i : arr) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr_1 = {1,2,3,4};
        display(productSum(arr));
        System.out.println();
        productSumWithOutDivision(arr);
        productSumWithOutDivision(arr_1);
    }
}
