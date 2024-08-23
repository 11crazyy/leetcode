package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum > 0) {
                    while (begin < end && nums[end] == nums[--end]) ;
                } else if (sum < 0) {
                    while (begin < end && nums[begin] == nums[++begin]) ;
                } else {
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[begin], nums[end])));
                    while (begin < end && nums[begin] == nums[++begin]) ;
                    while (begin < end && nums[end] == nums[--end]) ;
                }
            }
        }
        return list;
    }
}