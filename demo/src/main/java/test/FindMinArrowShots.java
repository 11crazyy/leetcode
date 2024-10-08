package test;

import java.util.Arrays;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        //找公共区间的个数
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
