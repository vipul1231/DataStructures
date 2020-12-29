package ds_facebook;

public class OneBillionUser {

    static int getBillionUsersDay(float[] growthRates) {
        // Write your code here

        double target = 1000000000;

        int start = 1;
        int end =  2000;
        double result = 0;

        while (start < end) {
            result = 0;
            int mid = start + (end-start)/2;

            for (float rate : growthRates) {
                result = result + calculateGrowth(rate, mid);
            }

            if (result == target) {
                return mid;
            }

            if(result > target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }

    static double calculateGrowth(float growth, int day) {
            return Math.pow(growth, day);
    }

    public static void main(String[] args) {

        float[] days = {1.5f};
        System.out.println(getBillionUsersDay(days));

    }
}
