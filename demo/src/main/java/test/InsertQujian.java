package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertQujian {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //先添加所有在newInterval之前的区间 再合并与newInterval有重叠的区间
        List<int[]> resultList = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1]<newInterval[0]){
            resultList.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        resultList.add(newInterval);
        while (i < intervals.length){
            resultList.add(intervals[i]);
            i++;
        }
        return resultList.toArray(new int[resultList.size()][]);
    }
}
