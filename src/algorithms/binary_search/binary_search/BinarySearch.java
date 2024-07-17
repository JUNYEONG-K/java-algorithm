package algorithms.binary_search.binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12, 15};
        int target = 3;
        System.out.println("binarySearch(nums, target, 0, nums.length - 1) = " + binarySearch(nums, target, 0, nums.length - 1));
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) return binarySearch(nums, target, mid + 1, right);
            if (nums[mid] > target) return binarySearch(nums, target, left, mid - 1);
            return mid;
        } else return -1;
    }
}
