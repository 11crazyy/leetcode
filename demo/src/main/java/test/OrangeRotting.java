package test;

import java.util.LinkedList;
import java.util.Queue;

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
        while (goodOranges > 0 && !queue.isEmpty()){
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
}
