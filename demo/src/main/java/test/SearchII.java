package test;

import java.util.Arrays;

public class SearchII {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0,right =len -1;
        while (left <= right){
            int mid = (left+right)/2;
            if (nums[mid]==target){
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
}
