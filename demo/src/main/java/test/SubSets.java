package test;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtracking(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list, int startIndex) {
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            backtracking(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
