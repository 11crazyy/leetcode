package test;

public class ShortestSubArray {
    //    public int minSubArrayLen(int target, int[] nums) {
//        //往队列里添加元素直到和大于等于target 从右边减少元素 如果和依然大于等于target 则更新minLen 否则左侧添加元素到队列
//        int low = 0, high = 0, minLen = Integer.MAX_VALUE, sum = 0;
//        while (low < nums.length) {
//            sum += nums[low++];
//            while (sum >= target) {
//                minLen = Math.min(minLen, low - high);
//                sum -= nums[high++];
//            }
//        }
//        return minLen == Integer.MAX_VALUE ? 0 : minLen;
//    }
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
