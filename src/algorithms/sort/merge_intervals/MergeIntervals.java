package algorithms.sort.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || interval[0] > merged.getLast()[1]) merged.add(interval);
            else merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        int[][] nums = new int[4][];
        nums[0] = new int[]{1, 3};
        nums[1] = new int[]{8, 11};
        nums[2] = new int[]{2, 6};
        nums[3] = new int[]{15, 18};
        System.out.println("nums = " + Arrays.deepToString(nums));
        int[][] merged = merge(nums);
        System.out.println("merged = " + Arrays.deepToString(merged));
    }
}
