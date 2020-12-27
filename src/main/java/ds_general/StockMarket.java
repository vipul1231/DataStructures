package ds_general;

public class StockMarket {

    public static int maxProfit(int[] prices) {
        int maxProfit  = 0;

        int min =prices[0];
        int minIndex = 0;

        int max = prices[0];
        int maxIndex = 0;

        for (int i=1;i<prices.length;i++) {

            int a = prices[i];

            if(a < min) {
                min = a;
                minIndex = i;
            }

            else if (a>max) {
                max = a;
                maxIndex = i;
            }
            else if (a > min && maxIndex < minIndex) {
                max = a;
                maxIndex = i;
            }


            if (minIndex < maxIndex && max - min > maxProfit) {
                maxProfit = max-min;
            }

        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] array_1 ={7,1,5,3,6,4};
        int[] array_2 = {3, 2, 8, 5, 12, 9};
        int[] array_3 = {7,6,4,3,1};
        System.out.println(maxProfit(array_1));
        System.out.println(maxProfit(array_2));
        System.out.println(maxProfit(array_3));
    }
}
