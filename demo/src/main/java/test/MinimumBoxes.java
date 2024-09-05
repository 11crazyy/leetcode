package test;

import java.util.Arrays;

public class MinimumBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int minimumNum = 0;
        Arrays.sort(capacity);
        int sumApple = 0;
        for (int i = 0; i < apple.length; i++) {
            sumApple += apple[i];
        }
        //按照容量从大到小装箱 直到所有苹果都装入箱子
        for (int i = capacity.length - 1; i >= 0; i--) {
            sumApple -= capacity[i];
            if (sumApple > 0) {
                minimumNum++;
            } else {
                break;
            }
        }
        return minimumNum + 1;
    }
}
