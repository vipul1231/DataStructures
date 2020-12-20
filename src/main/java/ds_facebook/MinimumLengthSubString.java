package ds_facebook;

import java.util.*;

public class MinimumLengthSubString {

    static class SourceObject {

        Map<String, Integer> mapper = new HashMap<>();

        public void addValueInMap(String[] array) {
            for (String value : array) {
                Integer indexes = mapper.get(value);
                if (indexes == null) {
                    mapper.put(value, 1);
                }
                else {
                    mapper.put(value, ++indexes);
                }
            }
            System.out.println(mapper);
        }

        /**
         * Add the value.
         *
         * @param value
         */
        public void addValue(String value) {
            Integer indexes = mapper.get(value);
            if (indexes == null) {
                mapper.put(value, 1);
            }
            else {
                mapper.put(value, ++indexes);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SourceObject that = (SourceObject) o;

            if (this.mapper.size() != that.mapper.size()) {
                return false;
            }
            else {
                return this.mapper.equals(that.mapper);
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(mapper);
        }
    }


    public static void main(String[] args) {
        //ABAACBAB
        String[] array_1 = {"A","B","A","A","C","B","A","B"};
        String[] t = {"A","B","C"};

        SourceObject sourceObject = new SourceObject();
        sourceObject.addValueInMap(t);

        SourceObject sourceObject1 = new SourceObject();

        int startIndex =0;
        int endIndex = 0;
        int length =1000;
        for(int i=startIndex;i<array_1.length;i++) {



            for(int j=endIndex;j<array_1.length;j++) {
                sourceObject1.addValue(array_1[j]);
                if (sourceObject1.equals(sourceObject)) {
                    int length_1 = Math.abs(startIndex - endIndex);
                    if (length_1 < length) {
                        length = length_1;
                        endIndex = j;
                        break;
                    }
                }
            }
        }
    }
}
