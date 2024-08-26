package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSum {
    public long maxSum(List<Integer> nums, int m, int k) {
        long max = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //初始化第一个窗口
        for (int i = 0; i < k; i++) {
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        if (map.size() >= m) {
            max = sum;
        }
        //滑动窗口
        for (int i = k; i < nums.size(); i++) {
            sum += nums.get(i) - nums.get(i - k);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            map.put(nums.get(i - k), map.get(nums.get(i - k)) - 1);
            if (map.get(nums.get(i - k)) == 0) {
                map.remove(nums.get(i - k));
            }
            if (map.size() >= m) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
