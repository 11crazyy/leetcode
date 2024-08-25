package test;

public class MinColorTimes {
    public int minimumRecolors(String blocks, int k) {
        int times = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                times++;
            }
        }
        int min = times;
        for (int i = 1; i <= blocks.length() - k; i++) {
            if (blocks.charAt(i - 1) == 'W') times--;
            if (blocks.charAt(i + k - 1) == 'W') times++;
            min = Math.min(min, times);
        }
        return min;
    }
}
