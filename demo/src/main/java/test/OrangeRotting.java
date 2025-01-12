package test;

import java.util.*;

public class OrangeRotting {
    public int orangesRotting(int[][] grid) {
        //广度优先搜索 从腐烂的橘子开始向四周蔓延
        Queue<int[]> queue = new LinkedList<>();//保存腐烂橘子的横纵坐标
        int res = 0;//遍历的次数
        int goodOranges = 0;//新鲜橘子的数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    goodOranges++;
                }
            }
        }
        if (goodOranges == 0) {
            return 0;
        }
        while (goodOranges > 0 && !queue.isEmpty()) {
            int n = queue.size();
            res++;
            for (int i = 0; i < n; i++) {
                int[] position = queue.poll();
                int x = position[0], y = position[1];
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    queue.add(new int[]{x - 1, y});
                    goodOranges--;
                }
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    queue.add(new int[]{x + 1, y});
                    goodOranges--;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    queue.add(new int[]{x, y - 1});
                    goodOranges--;
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    queue.add(new int[]{x, y + 1});
                    goodOranges--;
                }
                if (goodOranges == 0) {
                    return res;
                }
            }
        }
        return -1;

    }

    public int[] findRedundantConnection(int[][] edges) {
        //去掉一个节点后树中节点不变（每个节点都至少连接一条边）去除冗余边
        //并查集 两个节点如果已经连接则说明这条边是冗余边
        int n = edges.length;

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;//存每个节点的父节点
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (!union(x, y, parent)) {
                return edge;
            }
        }
        return new int[]{0, 0};
    }

    int findParent(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = findParent(parent[x], parent);
        }
        return parent[x];
    }

    boolean union(int x, int y, int[] parent) {
        int rootX = findParent(x, parent);
        int rootY = findParent(y, parent);
        if (rootY == rootX) {
            return false;//已经连接 说明是冗余边
        }
        parent[rootX] = rootY;
        return true;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        //最长公共子序列的长度 dp[i][j]表示text1[0:i]和text2[0:j]的最长公共子序列 dp[i][j]=dp[i-1][j-1]+1
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));//替换
                }
            }
        }
        return dp[len1][len2];
    }

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<String>();
        char[] path = new char[n];
        dfs(0, path, n, res);
        return res;
    }

    public void dfs(int i, char[] path, int n, List<String> res) {
        if (i == n) {//边界条件
            res.add(new String(path));
            return;
        }
        path[i] = '1';//填1
        dfs(i + 1, path, n, res);
        if (i == 0 || path[i - 1] == '1') {//此时可以填0
            path[i] = '0';//填0
            dfs(i + 1, path, n, res);
        }
    }

    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];//长度为dp[i]的子序列的个数
        int[] dp = new int[nums.length];//以nums[i]结尾的最长递增子序列的长度
        int res = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        len[i] = len[j];
                        dp[i] = dp[j] + 1;
                    } else if (dp[i] == dp[j] + 1) {
                        len[i] += len[j];
                    }
                }
            }
            if (res < dp[i]) {
                res = dp[i];
                maxLen = len[i];
            } else if (res == dp[i]) {
                maxLen += len[i];
            }
        }
        return maxLen;
    }

    public int minimumOperations(List<Integer> nums) {
        //使nums成为非递减顺序所需要的最小操作数
        int res = 100;
        int[] dp = new int[nums.size()];//dp[i]表示以nums[i]结尾的最小操作数
        for (int i = 0; i < nums.size(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums.get(i) >= nums.get(j)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    public String getSmallestString(String s) {
        //从左往右遍历 交换相邻的奇偶性一样的且前面大于后面
        for (int i = 0; i < s.length() - 1; i++) {
            int t1 = s.charAt(i) - '0';
            int t2 = s.charAt(i + 1) - '0';
            if ((t1 + t2) % 2 == 0 && t1 > t2) {
                char c = s.charAt(i);
                s = s.substring(0, i) + s.charAt(i + 1) + c + s.substring(i + 2, s.length());
                break;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        OrangeRotting orangeRotting = new OrangeRotting();
        System.out.println(orangeRotting.minChanges(13, 4));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];//dp[i][0]表示目前持有股票，对应的最大收益；dp[i][1]表示目前不持有股票且这天之后处于冷冻期，对应的最大收益；dp[i][2]表示目前不持有股票且不处于冷冻期，对应的最大收益
        //dp[i][0] = max(dp[i-1][0],dp[i-1][2]+prices[i])
        //dp[i][1] = dp[i-1][0]+prices[i]
        //dp[i][2] = max(dp[i-1][1],dp[i-1][2])
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }

    public int maxProfit(int[] prices, int fee) {
        //dp[i][0]表示第i天结束后手上持有股票的最大收益 dp[i][1]表示第i天结束后手上不持有股票的最大收益
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];//dp[i][0] = max(dp[i-1][0],dp[i-1][i-1][1]-prices[i]) dp[i][1] = max(dp[i-1][1],dp[i-1][0]+prices[i]-fee)
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        //求能量最大值 如果要切换则需要间隔1h
        int n = energyDrinkA.length;
        long[][] dp = new long[n][2];//dp[i][0]表示第i步从A取 dp[i][1]表示第i步从B取
        //dp[i][0] = eA[i] + max(dp[i-2][1],dp[i-1][0])
        //dp[i][1] = eB[i] + max(dp[i-1][1],dp[i-2][0])
        dp[0][0] = energyDrinkA[0];
        dp[1][0] = energyDrinkA[0] + energyDrinkA[1];
        dp[0][1] = energyDrinkB[0];
        dp[1][1] = energyDrinkB[0] + energyDrinkB[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = energyDrinkA[i] + Math.max(dp[i - 2][1], dp[i - 1][0]);
            dp[i][1] = energyDrinkB[i] + Math.max(dp[i - 1][1], dp[i - 2][0]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int longestSubarray(int[] nums) {
        //删除一个元素后连续1的最长长度 计算滑动窗口中0的数量 保证只含有一个0的窗口中1的数量最多
        int n = nums.length;
        int res = 0, left = 0;
        int count0 = 0, count1 = 0;//窗口中0和1的数量
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            while (count0 > 1) {
                if (nums[left] == 0) {
                    count0--;
                }
                left++;
            }
            res = Math.max(res, i - left);
        }
        return res;
    }

    public int minChanges(int n, int k) {
        //如果k不是n的子集 返回-1 如果k是n的子集 结果为n-k的大小
        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }

    public boolean validPartition(int[] nums) {
        //dp[0]=true dp[i+1]表示能否有效划分[0,i]
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        //dp[i] = dp[i-1]&&nums[i] == nums[i-1] || dp[i-2]&&nums[i-1]==nums[i-2] || dp[i-2]&&nums[i] == nums[i-1]+1==nums[i-2]+2
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] && nums[i] == nums[i - 1] ||
                    i > 1 && dp[i - 2] && (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                            nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2)) {
                dp[i + 1] = true;
            }
        }
        return dp[n];
    }
}