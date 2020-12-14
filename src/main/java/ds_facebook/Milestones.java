package ds_facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Milestones {

    static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        // Write your code here
        int[] milestonesDuplicate = new int[milestones.length];

        for(int i =0;i<milestones.length;i++) {
            milestonesDuplicate[i] = milestones[i];
        }
        Arrays.sort(milestones);
        int milestonesCount = 0;
        int[] result = new int[milestones.length];
        int sum = 0;
        for (int i = 0; i < revenues.length; i++) {
            sum = sum + revenues[i];
            if(milestonesCount >= milestones.length)
                break;
            int mileStone = milestones[milestonesCount];

            if (sum >= mileStone) {
                result[milestonesCount] = i + 1;
                milestonesCount++;
                if (milestonesCount < milestones.length) {
                    while (true) {
                        int checkAnotherMilestonesAlsoAchieved = milestones[milestonesCount];

                        if (checkAnotherMilestonesAlsoAchieved <= sum) {
                            result[milestonesCount] = i + 1;
                            milestonesCount++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int i=0;i<result.length;i++) {
            resultMap.put(milestones[i], result[i]);
        }
        int[] ans = new int[result.length];

        for(int i=0;i<result.length;i++) {
            ans[i] = resultMap.get(milestonesDuplicate[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        String[] milestone = scanner.nextLine().split(" ");

        int[] revenue = Stream.of(array).mapToInt(Integer::parseInt).toArray();
        int[] milestones = Stream.of(milestone).mapToInt(Integer::parseInt).toArray();

        getMilestoneDays(revenue, milestones);

        scanner.close();
    }
}
