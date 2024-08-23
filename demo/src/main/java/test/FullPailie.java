package test;

import java.util.ArrayList;
import java.util.List;

public class FullPailie {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracting(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void backtracting(int[] nums, List<List<Integer>> result, List<Integer> list, int startIndex) {
        if (startIndex == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            swap(nums,i,startIndex);
            list.add(nums[startIndex]);
            backtracting(nums, result, list, startIndex + 1);
            swap(nums,i,startIndex);
            list.remove(list.size() - 1);
        }
    }
    public void swap(int[] nums,int i,int index){
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }
}
