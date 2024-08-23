package test;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, result, new ArrayList<Integer>(), 1);
        return result;
    }

    public void backtracking(int n, int k, List<List<Integer>> result, List<Integer> list, int startIndex) {
        if (list.size()==k){
            result.add(new ArrayList<>(list));
        }
        for (int i = startIndex; i < n + 1; i++) {
            list.add(i);
            backtracking(n, k, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
