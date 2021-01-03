package ds_general;

public class DecodeWa {
//TODO: returning wrong answer for 1, returning 0 but it should return
    public static int numDecodings(String s) {
        String[] s1 = s.split("");

        int ctr1 = 0, ctr2 = 0;

        for (int i = 0; i < s1.length; i++) {

            if (i == 0 && !s1[i].equals("0")) {
                ctr1 = 1;
            }
            else if (i==1 && !s1[i].equals("0")) {

                int v2 = Integer.parseInt(s.substring(i - 1, i + 1));
                if (v2 >= 10 && v2 <= 26) {
                    ctr2 = 2;
                }
                else {
                    ctr2 = ctr1;
                }
            }

            else {
                int total = 0;
                int v1 = Integer.parseInt(s1[i]);
                if (v1 != 0) {
                    total += ctr2;
                }

                if (i > 0 && i<=s1.length-1) {
                    int v2 = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (v2 >= 10 && v2 <= 26) {
                        total = total + ctr1;
                    }
                }
                ctr1 = ctr2;
                ctr2 = total;
            }
        }

        return ctr2;
    }

    public static void main(String[] args) {
        /*String s = "1226";
        System.out.println(numDecodings(s));
        String s2 = "0";
        System.out.println(numDecodings(s2));
        String s1 = "00";
        System.out.println(numDecodings(s1));

        String s3 = "10011";
        System.out.println(numDecodings(s3));

        String s4 = "2101";
        System.out.println(numDecodings(s4));*/

        String s5 = "1";
        System.out.println(numDecodings(s5));
    }
}
