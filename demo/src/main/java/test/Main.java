package test;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DP dp = new DP();
        int costt = dp.minCostClimbingStairs(new int[]{10,15,20});
        System.out.println(costt);
    }
}