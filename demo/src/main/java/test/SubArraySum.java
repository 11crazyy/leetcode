package test;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        //每次更新前缀和之后 通过查找current_sum - K是否出现在哈希表中来判断是否存在连续子数组和为K
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cur = 0;
        for (int sum : nums) {
            cur += sum;//计算当前的前缀和
            if (map.containsKey(cur - k)) {
                ans += map.get(cur - k);
            }

            map.put(cur, map.getOrDefault(cur, 0) + 1);//统计前缀和出现的个数
        }
        return ans;
    }
}
