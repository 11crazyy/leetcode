package test;

public class ShortestSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0, high = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (low < nums.length) {
            sum += nums[low++];
            while (sum >= target) {
                minLen = Math.min(minLen, low - high);
                sum -= nums[high++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
