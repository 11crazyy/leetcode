package test;

import java.util.Arrays;

public class MaxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0, len = 0;
        while (len < costs.length && sum + costs[len] <= coins) {
            sum += costs[len++];
        }
        return len;
    }
}
