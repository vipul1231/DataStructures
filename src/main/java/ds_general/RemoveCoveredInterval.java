package ds_general;

import org.junit.Assert;

public class RemoveCoveredInterval {

    static public int removeCoveredIntervals(int[][] intervals) {

        int row  = intervals.length;

        int overlapping = 0;
        for (int i=0;i<row;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int j=0;j<row;j++) {
                int start_1 = intervals[j][0];
                int end_1 = intervals[j][1];

                if (i!=j && start_1 <= start && end <= end_1) {
                    overlapping += 1;
                    break;
                }
            }
        }

        return row - overlapping;
    }


    public static void main(String[] args) {

        int[][] array_1 = {{1,4},{3,6},{2,8}};
        int[][] array_2 = {{3,10},{4,10},{5,11}};
        int[][] array_3 = {{0,10},{5,12}};
        int[][] array_4 = {{1,4},{2,3}};
        int[][] array_5 = {{1,2},{1,4},{3,4}};
        int[][] array_6 = {{34335,39239},{15875,91969},{29673,66453},{53548,69161},{40618,93111}};
        System.out.println(removeCoveredIntervals(array_1));
        Assert.assertEquals(2, removeCoveredIntervals(array_1));
        System.out.println(removeCoveredIntervals(array_2));
        Assert.assertEquals(2, removeCoveredIntervals(array_2));
        System.out.println(removeCoveredIntervals(array_3));
        Assert.assertEquals(2, removeCoveredIntervals(array_3));
        System.out.println(removeCoveredIntervals(array_4));
        Assert.assertEquals(1, removeCoveredIntervals(array_4));
        System.out.println(removeCoveredIntervals(array_5));
        Assert.assertEquals(1, removeCoveredIntervals(array_5));


        System.out.println(removeCoveredIntervals(array_6));
    }
}
