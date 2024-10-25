package test;

import java.util.Arrays;
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
        for (int i = 1; i < skills.length && win < k; i++) {
            if (skills[i] > skills[max]) {
                max = i;
                win = 0;
            }
            win++;
        }
        return max;
    }

    public int maxTotalReward(int[] rewardValues) {
        //f[j] = f[j] || f[j-v]表示能不能得到奖励数j
        Arrays.sort(rewardValues);
        int sum = 0;
        for(int rewardValue : rewardValues){
            sum += rewardValue;
        }
        boolean[] dp = new boolean[2*rewardValues[rewardValues.length-1]];
        dp[0] = true;
        for(int rewardValue : rewardValues){
            for(int j = 2*rewardValue-1;j >= rewardValue;j--){
                dp[j] = dp[j] || dp[j-rewardValue];
            }
        }
        int res = 0;
        for(int i = 0;i < dp.length;i++){
            if(dp[i]){
                res = i;
            }
        }
        return res;
    }
}
