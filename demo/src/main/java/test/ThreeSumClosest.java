package test;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 99999;
        for (int i = 0; i < nums.length; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end){
                int sum = nums[i] + nums[begin] + nums[end];
                if (Math.abs(sum-target) < Math.abs(target-best)){
                    best = sum;
                }
                if (sum > target){
                    while (begin < end && nums[end] == nums[--end]);
                } else if (sum < target) {
                    while (begin < end && nums[begin] == nums[++begin]);
                }else {
                    return sum;
                }
            }
        }
        return best;
    }
}
