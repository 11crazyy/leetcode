package test;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        //计算上升趋势的利润和
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int profit = prices[i] - prices[i - 1];
                maxProfit += profit;
            }
        }
        return maxProfit;
    }
}
