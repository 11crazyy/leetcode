package test;

import java.util.Arrays;

public class NumSquares {
    public int numSquares(int n) {
        //dp[j] = Math.min(dp[j],dp[j-i*i] + 1);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int x = i * i;
            for (int j = x; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[n];
    }
}
