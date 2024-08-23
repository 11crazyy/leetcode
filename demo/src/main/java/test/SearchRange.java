package test;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {

                while (nums[low] != target) {
                    low++;
                }
                while (nums[high] != target) {
                    high--;
                }
                return new int[]{low, high};
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
