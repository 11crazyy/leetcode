package test;

public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            if (nums[low] == target) return low;
            if (nums[high] == target) return high;
            int mid = (low + high) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[low] < nums[mid]){
                if (target > nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }else {
                if (target > nums[mid] && target < nums[high]){
                    low = mid + 1;
                }else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
