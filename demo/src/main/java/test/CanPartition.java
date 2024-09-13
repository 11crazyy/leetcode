package test;
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int partition = sum / 2;
        //背包问题 找数组中和为partition的子数组
        boolean[] dp = new boolean[partition + 1];//dp[j]表示和为j的子数组是否存在
        dp[0] = true;//和为0的子数组一定存在、
        for (int i = 0; i < nums.length; i++) {
            for (int j = partition; j >= 0; j++) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[partition];
    }
}
