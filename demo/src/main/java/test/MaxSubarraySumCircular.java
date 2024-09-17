package test;

public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int maxS = Integer.MIN_VALUE;//最大子数组和
        int minS = 0;//最小子数组和
        int maxCur = 0;//当前最大子数组和
        int minCur = 0;//当前最小子数组和
        int sum = 0;//整个数组的和
        for (int num : nums) {
            maxCur = Math.max(maxCur, 0) + num;
            maxS = Math.max(maxS, maxCur);
            minCur = Math.min(minCur, 0) + num;
            minS = Math.min(minCur, minS);
            sum += num;
        }
        return minS == sum ? maxS : Math.max(maxS, sum - minS);
    }
}
