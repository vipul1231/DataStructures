package ds_general;

public class MakeStringGreat {


    public static String makeGood(String s) {
        int start =0;
        int end = s.length();
        while (start <= end-2){
            if ( Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(start+1)) && ( Character.isUpperCase(s.charAt(start)) && Character.isLowerCase(s.charAt(start+1)) || (Character.isLowerCase(s.charAt(start)) && Character.isUpperCase(s.charAt(start+1))))) {
                s = s.substring(0, start) + s.substring(start+2);
                end = end - 2;
                if (start != 0)
                start = start - 1;
                continue;
            }
            start++;
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        //System.out.println(makeGood(s));

        String s3 = "aA";
        //System.out.println(makeGood(s3));

        String s1 = "abBAcC";
        //System.out.println(makeGood(s1));

        String s2 = "ddsdsDdfdfdsfdRrrR";
        System.out.println(makeGood(s2));
    }
}
