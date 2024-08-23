package test;

public class ClibStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[1] = 2;//二阶
        dp[0] = 1;//一阶
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
