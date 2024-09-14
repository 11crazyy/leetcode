package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP {
    public int minCostClimbingStairs(int[] cost) {
        //从下标0或下标1开始爬楼梯的最小费用
        int[] dp = new int[cost.length + 1];//爬到第i层楼梯的最小费用
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1]+cost[i-1], dp[i - 2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
