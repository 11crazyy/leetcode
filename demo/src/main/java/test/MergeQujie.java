package test;

import java.util.Arrays;

public class MergeQujie {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<=1) return intervals;
        //排序 判断现在区别和已存在的最后一个区间是否重合 不重合直接添加 否则合并后添加
        int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        result[0] = intervals[0];
        int t = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > result[t][1]){//如果不重叠
                result[++t] = intervals[i];
            }else {//否则更新区间 t不变
                result[t][1] = Math.max(intervals[i][1],result[t][1]);
            }
        }
        return Arrays.copyOf(result,t + 1);
    }
}
