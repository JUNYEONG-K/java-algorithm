package algorithms.binary_search.search_in_rotated_sorted_array;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        int pivot = left;

        left = 0; right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midPivot = (mid + pivot) % nums.length;

            if (nums[midPivot] < target) left = mid + 1;
            else if (nums[midPivot] > target) right = mid - 1;
            else return midPivot;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 0, 1, 2};
        int target = 1;

        System.out.println("search(nums, target) = " + search(nums, target));
    }
}
