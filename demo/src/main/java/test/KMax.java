package test;

import java.util.HashMap;
import java.util.Map;

public class KMax {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //初始化第一个窗口
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //判断唯一性
        if (map.size() == k) {
            max = sum;
        }
        //滑动窗口
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[i - k], map.get(nums[i - k]) - 1);
            if (map.get(nums[i - k]) == 0) {
                map.remove(nums[i - k]);
            }
            if (map.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
