package test;

public class MincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        //Math.min(dp(daysSum-30)+costs[2],dp(daysSum-7)+costs[1],dp(daysSum-1)+cost[0])
        //如果今天不是旅行日 花费和前一天一样
        int n = days.length;
        int lastDay = days[n - 1];//最后一天的日期
        boolean[] isTravel = new boolean[lastDay + 1];//是否是旅行日
        for (int day : days) {
            isTravel[day] = true;
        }
        int[] dp = new int[lastDay + 1];//dp[i]表示到第i天的最小花费
        for (int i = 1; i <= lastDay; i++) {
            if (!isTravel[i]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], Math.min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1]));
            }
        }
        return dp[lastDay];
    }
}
