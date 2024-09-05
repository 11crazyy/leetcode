package test;

import java.util.*;

public class FindLeastNum {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //用新数组统计各个元素出现次数 移除出现次数最少的数 直到移除k个
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int len = map.size();
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        for (int i : list) {
            if (k >= i) {
                k -= i;
                len--;
            } else {
                break;
            }
        }
        return len;
    }
}
