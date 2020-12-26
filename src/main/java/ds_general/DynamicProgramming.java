package ds_general;


public class DynamicProgramming {


    private static float dpFibonacciSeries(float arr, float[] index) {

        if (index[(int)arr] != 0) {
            return index[(int)arr];
        }
        if (arr <= 2) {
            return 1;
        }
        else {
            index[(int)arr] = dpFibonacciSeries(arr-1, index) + dpFibonacciSeries(arr-2, index);
        }
        return index[(int)arr];
    }

    public static void main(String[] args) {
        float[] arr = new float[1000];
        System.out.println(dpFibonacciSeries(50f, arr));
    }
}
