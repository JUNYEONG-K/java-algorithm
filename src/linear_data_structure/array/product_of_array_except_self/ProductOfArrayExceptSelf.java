package linear_data_structure.array.product_of_array_except_self;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int p = 1;
        for (int num : nums) {
            p *= num;
        }

        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = p / nums[i];
        }

        return results;
    }

    static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7};
        int[] product = productExceptSelf(nums);
        System.out.println("product = " + Arrays.toString(product));
        int[] product2 = productExceptSelf2(nums);
        System.out.println("product2 = " + Arrays.toString(product2));
    }
}
