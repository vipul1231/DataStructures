package ds_general;

public class PalindromicSubString {


    public static String longestPalindrome_1(String s) {
        //System.out.println(s);
        int[][] dp = new int[s.length()][s.length()];
        int length=0;
        String palindromicString = null;

        if (s.length() == 1) {
            return s;
        }

        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }
        else if(s.length() == 2 && s.charAt(0) != s.charAt(1)){
            return s.split("")[0];
        }


        for (int i=0;i<s.length();i++) {
            dp[i][i] = 1;
            if ((i+1 != s.length()) && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                String s1 = s.substring(i, i+2);
                if (s1.length() > length) {
                    length = s1.length();
                    palindromicString = s1;
                }
            }
        }

        //display(dp);
        int count = 2;
        int l = 0;
        for (int i = 0 ;i< s.length();i++) {
            for (int j = i+count; j<s.length();j++) {
                if (s.charAt(l) == s.charAt(j) && dp[l+1][j-1] == 1) {
                    dp[l][j] = 1;
                    String s1 = s.substring(l,j+1);
                    if (s1.length() > length) {
                        length = s1.length();
                        palindromicString = s1;
                    }
                }
                l++;
            }
            l=0;
        }

        //display(dp);

        if(palindromicString == null) {
            return s.substring(0,1);
        }
        return palindromicString;

    }

    private static void display(int[][] arr)
    {
        for (int i = 0;i<arr.length;i++) {
            for (int j =0; j< arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {

        System.out.println(longestPalindrome_1("dabcba"));
        System.out.println(longestPalindrome_1("babad"));
        System.out.println(longestPalindrome_1("bb"));
        System.out.println(longestPalindrome_1("bcdaa"));
        System.out.println(longestPalindrome_1("a"));
        System.out.println(longestPalindrome_1("ac"));
        System.out.println(longestPalindrome_1("cbbd"));
        System.out.println(longestPalindrome_1("xyztarratabc"));
        System.out.println(longestPalindrome_1("abcda"));
    }

}
