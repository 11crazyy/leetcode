package test;

import java.util.HashMap;
import java.util.Map;

public class MyCalendarTwo {
    Map<Integer, int[]> tree;//key是索引idx，value是int[] tree.get(idx)[0]表示当前区间最大重叠次数 tree.get(idx)[1]表示未更新到子节点的累计值

    public MyCalendarTwo() {
        tree = new HashMap<Integer, int[]>();
    }

    public boolean book(int startTime, int endTime) {
        update(startTime, endTime - 1, 1, 0, 1000000000, 1);//[start,end-1]重叠次数+1
        //如果重叠次数大于2，说明有三个区间重叠，需要回滚
        tree.putIfAbsent(1, new int[2]);
        if (tree.get(1)[0] > 2) {
            update(startTime, endTime - 1, -1, 0, 1000000000, 1);//[start,end-1]重叠次数-1
            return false;
        }
        return true;
    }

    public void update(int start, int end, int val, int l, int r, int idx) {
        if (r < start || end < l) {
            return;//如果没有交集 直接返回
        }
        tree.putIfAbsent(idx, new int[2]);
        if (start <= l && r <= end) {
            tree.get(idx)[0] += val;//更新当前区间的重叠次数
            //更新懒惰标记（tree.get(idx)[1]），表示子区间需要延迟更新。
            tree.get(idx)[1] += val;
        } else {
            int mid = (l + r) >> 1;
            update(start, end, 1, l, mid, 2 * idx);//更新左子区间
            update(start, end, 1, mid + 1, r, 2 * idx + 1);//更新右子区间
            tree.putIfAbsent(2 * idx, new int[2]);
            tree.putIfAbsent(2 * idx + 1, new int[2]);
            tree.get(idx)[0] = tree.get(idx)[1] + Math.max(tree.get(2 * idx)[0], tree.get(2 * idx + 1)[0]);//更新当前区间的重叠次数
        }
    }
    //计算数组中所有第k位是1的数的个数
    public int countKOne(int[] candidates,int k){
        int count = 0;
        for(int c : candidates){
            if((c & (1 << k)) != 0){
                count++;
            }
        }
        return count;
    }
    public int largestCombination(int[] candidates) {
        int max = 0;
        for(int i = 0;i < 24;i++){
            max = Math.max(max,countKOne(candidates,i));
        }
        return max;
    }
}
