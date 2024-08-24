package test;

import java.util.Arrays;

public class minimumDifference {
    public int minimumDifference(int[] nums, int k) {
        //排序+滑动窗口
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
