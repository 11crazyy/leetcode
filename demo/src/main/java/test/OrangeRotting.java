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
        Map<Integer,Integer> map = new HashMap<>();//子序列对应的长度以及个数
        int[] dp = new int[nums.length];
        int res = 0;
        for(int i = 0;i < nums.length; i++){
            dp[i] = 1;
            int len = 0;
            for(int j = 0; j <= i;j++){
                if(dp[i]>dp[j]){
                    len++;
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }else{
                    map.put(len,map.getOrDefault(len,0)+1);
                    len = 0;
                }
            }
            res = Math.max(dp[i],res);
        }
        return map.get(res);
    }
}
