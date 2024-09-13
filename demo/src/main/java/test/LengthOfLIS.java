package test;

public class LengthOfLIS {
    //dp[i] = max(dp[j]+1,dp[i]) 0 <=j<i
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
