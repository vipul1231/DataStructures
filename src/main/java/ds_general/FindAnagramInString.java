package ds_general;

import java.util.*;
import java.util.stream.Collectors;

public class FindAnagramInString {

    public int identifyAsciiValue(String word) {

        String[] words = word.split("");
        int total =0;
        for(int i=0;i<words.length;i++) {
            int charValue = word.charAt(i);
            total += charValue;
        }
        return total;
    }


    class AnagramOutput {

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        final String key;

        final Integer value;

        AnagramOutput(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key+":"+value;
        }
    }

    public List<String> identifyAnagrams(List<String> anagrams) {

        List<AnagramOutput> countArray = new ArrayList<>();
        // n
        for(int i=0;i<anagrams.size();i++) {
            String s1 = anagrams.get(i);
            countArray.add(new AnagramOutput(s1, identifyAsciiValue(s1)));
        }

        // nlogn
        Collections.sort(countArray, returnComp());
        System.out.println(countArray);
        //
        return countArray.stream().map(AnagramOutput::getKey).collect(Collectors.toList());

    }


    public Comparator returnComp() {

        return new Comparator<AnagramOutput>() {

            public int compare(AnagramOutput obj1, AnagramOutput obj2) {

                if(obj1.key.equals(obj2.key)) {
                    return obj1.value.compareTo(obj2.value);
                }
                return obj1.key.compareTo(obj2.key);
            }
        };


    }

    public static void main(String[] args) {

        String[] strArray2 = {"abc","xyddf","ade","2q4r32tr","21","bca","bdfer","12","cde","bdf"};
        FindAnagramInString obj = new FindAnagramInString();
        System.out.println(obj.identifyAnagrams(Arrays.asList(strArray2)));
    }
}
