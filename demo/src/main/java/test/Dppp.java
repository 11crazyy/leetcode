package test;

import java.util.HashMap;
import java.util.Map;

public class Dppp {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - 2 * dp[target];
    }

    public int findWinningPlayer(int[] skills, int k) {
        int max = 0;
        int win = 0;
        for(int i = 1;i < skills.length && win < k;i++){
            if(skills[i]>skills[max]){
                max = i;
                win = 0;
            }
            win++;
        }
        return max;
    }
}
