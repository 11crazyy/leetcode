package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracting(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    public void backtracting(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            backtracting(candidates, target - candidates[i], result, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
