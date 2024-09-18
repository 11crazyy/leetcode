package test;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[i]表示到达第i层索引为j的最小路径和 dp[i][j] = min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i.get(j))
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + list.get(0);//最左边的元素
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + list.get(i);//最右边的元素
        }
        for (int i = 0; i < triangle.size(); i++) {
            ans = Math.min(ans, dp[triangle.size() - 1][i]);
        }
        return ans;
    }
}
