package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullPailieII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<Integer>(), used);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, result, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
