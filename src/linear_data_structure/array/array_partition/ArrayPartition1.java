package linear_data_structure.array.array_partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayPartition1 {
    static int arrayPairSum(int[] nums) {
        int sum = 0;
        ArrayList<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);

        for (int num : nums) {
            pair.add(num);
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }

        return sum;
    }

    static int arrayPairSum2(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5, 6};
//        int sum = arrayPairSum(nums);
        int sum = arrayPairSum2(nums);
        System.out.println("sum = " + sum);
    }
}
