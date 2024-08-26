package test;

public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        //找一个长度为cardPoints.length-k的和最小的连续子数组
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        //初始化第一个窗口
        int sum1 = 0, min = 0;
        int len1 = cardPoints.length - k;
        for (int i = 0; i < len1; i++) {
            sum1 += cardPoints[i];
        }
        min = sum1;
        for (int i = 1; i <= cardPoints.length - len1; i++) {
            sum1 += cardPoints[i + len1 - 1] - cardPoints[i - 1];
            min = Math.min(sum1, min);
        }
        return sum - min;
    }
}
