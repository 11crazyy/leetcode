package test;

import java.util.Arrays;

public class LargestSumAfterK {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        //先把所有负数取反 如果k==0直接返回 k是偶数也直接返回 k是奇数把取反后最小的数取反
        int i = 0;
        while (k > 0 && i < nums.length && nums[i] < 0) {
            nums[i] = -nums[i];
            k--;
            i++;
        }
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
        }
        if (k == 0 || k % 2 == 0) {
            return sum;
        } else {
            Arrays.sort(nums);
            return sum -= 2 * nums[0];
        }
    }
}
