package test;

public class LoveAngryBoss {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //找连续三个grumpy值为1的区间  让这个区间的顾客满意度最大
        int result = 0, max = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                result += customers[i];
            }
        }
        max = result;
        for (int i = 1; i <= customers.length - minutes; i++) {
            if (grumpy[i - 1] == 1) {
                result -= customers[i - 1];
            }
            if (grumpy[i + minutes - 1] == 1) {
                result += customers[i + minutes - 1];
            }
            max = Math.max(max, result);
        }
        return max;
    }
}
