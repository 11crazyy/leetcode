package test;

public class Rob {
    public int rob(int[] nums) {
        //第i间房子的最大金额=前i-2间房子的最大金额+当前房间的金额 与 前i-1间房子的最大金额 两者的最大值
        //dp[i = max(dp[i-2]+nums[i],dp[i-1])
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
