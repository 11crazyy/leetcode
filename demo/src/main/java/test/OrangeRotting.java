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

        int[] parent = new int[n+1];
        for (int i = 1; i <= n;i++){
            parent[i] = i;//存每个节点的父节点
        }
        for(int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            if (!union(x,y,parent)){
                return edge;
            }
        }
        return new int[]{0,0};
    }
    int findParent(int x,int[] parent){
        if (x != parent[x]){
            parent[x] = findParent(parent[x],parent);
        }
        return parent[x];
    }
    boolean union(int x,int y,int[] parent){
        int rootX = findParent(x,parent);
        int rootY = findParent(y,parent);
        if (rootY == rootX){
            return false;//已经连接 说明是冗余边
        }
        parent[rootX] = rootY;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0}, {0,1}};
        OrangeRotting orangeRotting = new OrangeRotting();
        boolean res = orangeRotting.canFinish(2,grid);
        System.out.println(res);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<int[], Integer> integerHashMap = new HashMap<>();
        for(int i = 0;i < prerequisites.length; i++){
            int[] prerequisite = prerequisites[i];
            Arrays.sort(prerequisite);
            integerHashMap.put(prerequisite,integerHashMap.getOrDefault(prerequisite,0)+1);
            if (integerHashMap.get(prerequisite) > 1){
                return false;
            }
        }
        return true;
    }

}
