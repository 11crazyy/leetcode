package test;

import java.util.Arrays;

public class CountTexts {
    private static final int MOD = 1000000007;
    private static final int MX = 100001;
    private static final long[] f = new long[MX];
    private static final long[] g = new long[MX];

    static {
        f[0] = g[0] = 1;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;
        f[3] = g[3] = 4;
        for (int i = 4; i < MX; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
            g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD;
        }
    }

    public int countTexts(String pressedKeys) {
        long ans = 1;
        int cnt = 0;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            cnt++;
            if (i == pressedKeys.length() - 1 || c != pressedKeys.charAt(i + 1)) {
                ans = ans * (c != '7' && c != '9' ? f[cnt] : g[cnt]) % MOD;
                cnt = 0;
            }
        }
        return (int) ans;
    }

    public int rob(int[] nums) {
        //偷nums[0]:2~n-1 不偷：1~n
        int n = nums.length;
        return Math.max(nums[0] + robb(2, n - 1, nums), robb(1, n, nums));
    }

    public int robb(int start, int end, int[] nums) {
        int t1 = 0, t2 = 0;
        for (int i = start; i < end; i++) {
            int t = Math.max(t1, t2 + nums[i]);
            t1 = t2;
            t2 = t;
        }
        return t2;
    }
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double res = 0;
        int n = nums.length;
        res = (double) (nums[n / 2 - 1] + nums[n / 2]) /2;
        return res;
    }
    public int deleteAndEarn(int[] nums) {
        //t相邻的元素（t+1、t-1）不能偷 返回所偷金额的最大值  Math.max(dp[i-1],dp[i-2]+points[i])
        int maxVal = 0;
        for(int num :nums){
            maxVal = Math.max(maxVal,num);
        }
        int[] points = new int[maxVal+1];//points[i]为i这个数对应的分数
        for(int num: nums){
            points[num] += num;
        }
        int[] dp = new int[maxVal + 1];
        dp[0] = 0;dp[1] = Math.max(points[1],points[0]);
        for(int i = 2;i < points.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+points[i]);
        }
        return dp[maxVal];
    }
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] dp = new int[s.length()];  // dp[i] 表示以第 i 个字符结尾的子串的最大开销
        dp[0] = Math.max(getValue(s.charAt(0), chars, vals), 0);  // 初始化第一个字符
        int res = dp[0];  // 初始化结果为第一个字符的值

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = getValue(c, chars, vals);  // 获取字符 c 的值
            dp[i] = Math.max(dp[i - 1] + value, value);  // 动态规划转移方程
            res = Math.max(dp[i], res);  // 更新结果
        }

        return res;
    }

    // 改进的获取字符值的方法
    private int getValue(char c, String chars, int[] vals) {
        for (int i = 0; i < chars.length(); i++) {
            if (chars.charAt(i) == c) {
                return vals[i];
            }
        }
        return c - 'a' + 1;  // 如果字符不在 chars 中，返回它的默认值
    }


    public static void main(String[] args) {
        CountTexts countTexts = new CountTexts();
        countTexts.maximumCostSubstring("hghhghgghh","hg",new int[]{2,3});
    }
}
