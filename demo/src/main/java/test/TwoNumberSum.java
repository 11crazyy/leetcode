package test;

import java.util.HashMap;

class TwoNumberSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0, ans = 0;
        for (int i = 1; i < n * 2; i++) {
            if (colors[i % n] == colors[(i - 1) % n]) {
                res = 0;
            }
            res++;

            if (i >= n && res >= k) {
                ans++;
            }
        }
        return ans;
    }
}
