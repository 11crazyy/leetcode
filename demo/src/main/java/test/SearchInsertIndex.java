package test;

public class SearchInsertIndex {
    public int searchInsert(int[] nums, int target) {
        int result = -1;
        int low = 0;
        int high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                result = mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result == -1 ? high + 1 : result;
    }
}
