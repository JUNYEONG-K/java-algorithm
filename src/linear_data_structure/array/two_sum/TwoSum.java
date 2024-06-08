package linear_data_structure.array.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    static int[] twoSumByBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    static int[] twoSumByMap(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i , numsMap.get(target - nums[i])};
            }
        }
        return null;
    }

    static int[] twoSumByMapAdvanced(int[] nums, int target) {
        Map<Integer, Integer> numsIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsIndexMap.containsKey(target - nums[i]) && i != numsIndexMap.get(target - nums[i]))
                return new int[]{i, numsIndexMap.get(target - nums[i])};
            numsIndexMap.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 11, 15};
        int target = 8;

//        int[] result = twoSumByBruteForce(nums, target);
//        int[] result = twoSumByMap(nums, target);
        int[] result = twoSumByMapAdvanced(nums, target);
        System.out.println("result = " + Arrays.toString(result));
    }
}
