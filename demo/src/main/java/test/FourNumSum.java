package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) { // 使用 long 类型来避免溢出
                break;
            }
            if ((long) nums[a] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) { // 使用 long 类型来避免溢出
                continue;
            }
            for (int b = a + 1; b < n - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                if ((long) nums[b] + nums[a] + nums[b + 1] + nums[b + 2] > target) { // 使用 long 类型来避免溢出
                    break;
                }
                if ((long) nums[b] + nums[a] + nums[n - 2] + nums[n - 1] < target) { // 使用 long 类型来避免溢出
                    continue;
                }
                int x = b + 1;
                int y = n - 1;
                while (x < y) {
                    long sum = (long) nums[a] + nums[b] + nums[x] + nums[y]; // 确保所有参与计算的变量都是 long 类型
                    if (sum == target) {
                        lists.add(new ArrayList<>(Arrays.asList(nums[x], nums[y], nums[a], nums[b])));
                        while (x < y && nums[x] == nums[++x]) ;
                        while (x < y && nums[y] == nums[--y]) ;
                    } else if (sum < target) {
                        while (x < y && nums[x] == nums[++x]) ;
                    } else {
                        while (x < y && nums[y] == nums[--y]) ;
                    }
                }
            }
        }
        return lists;
    }
}
