package ds_contest;

import java.util.*;

public class FindRangeAndDuplicates {

    static class ProgressionHolder {
        private int start;
        private int end;
        private List<Integer> list = new ArrayList<>();
        private int cd;

        public int getSubset() {
            return subset;
        }

        public void setSubset(int subset) {
            this.subset = subset;
        }

        public int getDuplicate() {
            return duplicate;
        }

        public void setDuplicate(int duplicate) {
            this.duplicate = duplicate;
        }

        private int subset;
        private int duplicate;

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        public int getCd() {
            return cd;
        }

        public void setCd(int cd) {
            this.cd = cd;
        }

        public String toString() {
            return "Start: "+start+", End: "+end;
        }
    }

    /**
     * Method Complexity = O(N)
     *
     * @param array_1
     * @return
     */
    public static List<ProgressionHolder> findAPInArray(int[] array_1) {
        List<ProgressionHolder> progressionHolderList = new ArrayList<>();
        boolean increment;
        for (int i=0;i<array_1.length-2;i++) {
            int num1 = array_1[i];
            int num2 = array_1[i+1];
            int num3 = array_1[i+2];
            //condition for checking AP with common diff
            if (Math.abs(num2-num1) == Math.abs(num3-num2)) {
                int cd = Math.abs(num2 - num1);
                List<Integer> numbers = new ArrayList<>();
                numbers.add(num1);
                numbers.add(num2);
                numbers.add(num3);
                increment = num1 < num2;
                i = i+2;
                //check for more elements in array and update the index i so that loop will not run on same elements
                while (i != array_1.length-1) {
                    int num4 = Math.abs(array_1[i+1]-array_1[i]);
                    if (num4 == cd) {
                        //If AP is increment or decrement for condition 17 19 21 or 0,2,4,6,8,2,4,6,4,6
                        if (increment && (array_1[i+1] > array_1[i])) {
                            numbers.add(array_1[i+1]);
                            i =i+1;
                            continue;
                        }
                        else if (!increment && array_1[i+1] < array_1[i]){
                            numbers.add(array_1[i+1]);
                            i =i+1;
                            continue;
                        }
                        break;
                    }
                    else {
                        break;
                    }
                }
                ProgressionHolder progressionHolder = new ProgressionHolder();
                Collections.sort(numbers);
                progressionHolder.setList(numbers);
                progressionHolder.setStart(numbers.get(0));
                progressionHolder.setEnd(numbers.get(numbers.size()-1));
                progressionHolder.setCd(cd);
                progressionHolderList.add(progressionHolder);
            }
        }
        progressionHolderList.sort(getComparator());
        return findRangeAndDuplicate(progressionHolderList);
    }

    /**
     * Method complexity: O(length of combination of AP's) will be less than O(N).
     *
     * This method will compare and merge the list according to the criteria and remove duplicate or subset
     * from the exisiting list.
     *
     * @param list  List
     * @return      List of progression holder
     */
    private static List<ProgressionHolder> findRangeAndDuplicate(List<ProgressionHolder> list) {
        for (int i=0;i<list.size();i++) {
            ProgressionHolder progressionHolder = list.get(i);
            int start = progressionHolder.getStart();
            int end = progressionHolder.getEnd();
            int index = i+1;
            while (index != list.size()) {
                ProgressionHolder compareAndMerge = list.get(index);
                if (compareAndMerge.getCd() == progressionHolder.getCd() && compareAndMerge.getEnd() <= end) {

                    if (compareAndMerge.getStart() == start && compareAndMerge.getEnd() == end) {
                        progressionHolder.setDuplicate(progressionHolder.getDuplicate() + 1);
                        list.remove(index);
                        continue;
                    }
                    else if (compareAndMerge.getStart() >= start && compareAndMerge.getEnd() < end) {
                        progressionHolder.setSubset(progressionHolder.getSubset() + 1);
                        list.remove(index);
                        continue;
                    }
                    else if (compareAndMerge.getStart() >= start && compareAndMerge.getEnd() <= end) {
                        progressionHolder.setSubset(progressionHolder.getSubset() + 1);
                        list.remove(index);
                        continue;
                    }
                }
                index = index +1;
            }
        }
        displayList(list);
        return list;
    }

    /**
     * This method wont be counted in complexity part and can be ignored
     *
     * @param display
     */
    private static void displayList(List<ProgressionHolder> display) {
        for (ProgressionHolder progressionHolder : display) {
            System.out.println("Start: "+progressionHolder.start+", End: "+progressionHolder.end+", Subset: "+progressionHolder.getSubset()+", Duplicate: "+progressionHolder.getDuplicate());
        }
    }

    /**
     * Comparator for sorting the AP's with start index ex
     *
     * [-7, -2, 0, 0, 13, 15, 17]
     *
     *
     *  -7, -4, -1
     *  -2, 0, 2, 4, 6, 8, 10
     *  0, 2, 4, 6
     *  0, 2, 4, 6
     *  13, 15, 17, 19, 21
     *  15, 17, 19
     *  17, 23, 29
     *
     * @return
     */
    private static Comparator<ProgressionHolder> getComparator() {
        return Comparator.comparingInt(ProgressionHolder::getStart);
    }

    public static void main(String[] args) {
        System.out.println("Test 1........");
        int[] test_1 = {-1, 21, 19, 17, 15, 13, 0, 2, 4, 6, 15, 17, 19, -1, -4,-7,-2,-100,0,2,4,6,17,23,29, 10,8,6,4,2,0,-2};
        List<ProgressionHolder> answer = findAPInArray(test_1);
        for (ProgressionHolder ph : answer) {
            if (ph.start == -2 && ph.end == 10) {
                assert ph.subset == 2;
                assert ph.duplicate == 0;
            }
            assert ph.start != 13 || ph.end != 21 || ph.subset == 1;
        }
        System.out.println("Test 2........");
        int[] test_2 = {0,2,4,6,8,0,2,4,6,8};
        answer = findAPInArray(test_2);
        assert answer.size() == 1;
        assert answer.get(0).duplicate == 1;

        System.out.println("Test 3........");
        int[] test_3 = {0,2,4,6,8,2,4,6};
        answer = findAPInArray(test_3);
        assert answer.size() == 1;
        assert answer.get(0).subset == 1;

        System.out.println("Test 4........");
        int[] test_4 = {0,2,4,6,8,2,4,6,4,6};
        answer = findAPInArray(test_4);
        assert answer.size() == 1;
        assert answer.get(0).subset == 1;

        System.out.println("Test 5........");
        int[] test_5 = {10,7,4,4,8,12,18,0,4,8,12};
        answer = findAPInArray(test_5);
        assert answer.size() == 2;
        assert answer.get(0).subset == 1;
    }
}
