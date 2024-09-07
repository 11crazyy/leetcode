package test;

import java.util.Arrays;

public class Candy {
    public int minimumCost(int[] cost) {
        //从小到大排序 从后往前遍历 买两个送一个
        int freeCost = 0;
        int j = 1, sumCost = 0;
        Arrays.sort(cost);
        for (int i = cost.length - 1; i >= 0; i--) {
            if (j % 3 == 0) {
                freeCost += cost[i];
            }
            sumCost += cost[i];
            j++;
        }
        return sumCost - freeCost;
    }
}
