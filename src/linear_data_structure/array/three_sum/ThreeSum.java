package linear_data_structure.array.three_sum;

import java.util.*;

public class ThreeSum {
    static List<List<Integer>> threeSumByBruteForceWithSort(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j+1 && nums[k] == nums[k-1]) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return result;
    }

    static List<List<Integer>> threeSumByTwoPointers(int[] nums) {
        int left, right, sum;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) left++;
                if (sum > 0) right--;
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++; right--;
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -5};
//        List<List<Integer>> lists = threeSumByBruteForceWithSort(nums);
        List<List<Integer>> lists = threeSumByTwoPointers(nums);
        System.out.println("lists = " + lists);
    }
}
