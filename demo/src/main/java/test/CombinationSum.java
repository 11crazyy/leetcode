package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates,target,new ArrayList<>(),result,0);
        return result;
    }
    public void dfs(int[] candidates,int target,List<Integer> path,List<List<Integer>> lists,int startIndex){
        if (target < 0){
            return;
        }
        if (target == 0){
            lists.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], path, lists, i);
            path.remove(path.size() - 1);
        }
    }
}
