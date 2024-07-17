package algorithms.sort.largest_number;

import java.util.Arrays;

public class LargestNumber {
    public static boolean toSwap(int n1, int n2) {
        // a + b 와 b + a 를 비교해 후자가 크면 스왑이 필요하므로 true 리턴
        return Long.parseLong(String.valueOf(n1) + n2)
                < Long.parseLong(String.valueOf(n2) + n1);
    }

    public static String largestNumber(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
            i++;
        }
        if (nums[0] == 0) return "0";
        else return Arrays.toString(nums).replaceAll("\\[|\\]|,|\\s", "");
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 8, 9};
        System.out.println("largestNumber(nums) = " + largestNumber(nums));
    }
}
