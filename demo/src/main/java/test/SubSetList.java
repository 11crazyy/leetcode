package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetList {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(result, nums, new ArrayList<>(), 0);
        return result;
    }

    public void backtracking(List<List<Integer>> result, int[] nums, List<Integer> list, int startIndex) {
        result.add(new ArrayList<>(list));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtracking(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
