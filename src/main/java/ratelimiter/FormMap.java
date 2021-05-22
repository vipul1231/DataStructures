package ratelimiter;


/**
 *
 */
public class FormMap {

    public static boolean verifySequence(String[] words, String order) {

        int length = words.length;

        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            int currVal;
            int min = Integer.MIN_VALUE;
            boolean flag = false;
            for (String word : words) {
                if (count >= word.length()) {
                    currVal = -1;
                } else {
                    currVal = order.indexOf(word.charAt(count)); // 0,1
                }

                if (currVal < min) {
                    return false;
                } else if (currVal == min) flag = true;

                min = currVal;


            }
            if (flag == false) return true;
            count++;
        }
        return true;
    }

    public static void main(String[] args) {

     String[]  words = {"hello","leetcode"};
     String order = "hlcabcdefgijkmnopqrstuvwxyz";

     boolean result = verifySequence(words, order);
     assert result == true;



     String[]  words_1 = {"word","world","row"};
     String order_1 = "worldabcefghijkmnpqstuvxyz";

     boolean result_1 = verifySequence(words_1, order_1);
     assert result_1 == false;


     String[]  words_2 = {"worless","word"};
     String order_2 = "worldabcefghijkmnpqstuvxyz";

     boolean result_2 = verifySequence(words_2, order_2);
     assert result_2 == true;

     String[]  words_3 = {"wordess","word"};
     String order_3 = "worldabcefghijkmnpqstuvxyz";

     boolean result_3 = verifySequence(words_3, order_3);
     assert result_3 == false;

    }
}
