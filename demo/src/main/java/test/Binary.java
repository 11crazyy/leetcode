package test;

import java.util.Arrays;
import java.util.Map;

public class Binary {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nums1[i];
        }
        int max = 0, sum = 0;
        Arrays.sort(ans);
        for (int i = 0; i < nums1.length; i++) {
            int res1 = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + res1) % 1000000007;
            int index = binary(ans, nums2[i]);//找到最接近nums2[i]的数 需要把nums1[i]换成ans[index]
            if (index < nums1.length) {
                max = Math.max(max, res1 - (ans[index] - nums2[i]));//最大的差值
            }
            if (index > 0) {
                max = Math.max(max, res1 - (nums2[i] - ans[index - 1]));//最大的差值
            }
        }
        return (sum - max + 1000000007) % 1000000007;
    }

    public int binary(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (nums[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int middle = (low + high) / 2;
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int sumTime = 0,middle = 0;
        while (low < high){
            middle = (low + high)/2;
            for (int i = 0; i < piles.length; i++) {
                sumTime += (piles[i] + middle - 1) / middle;
            }
            if (sumTime > h){
                low = middle + 1;
            }else {
                high = middle;
            }
            sumTime = 0;
        }
        return low;
    }
}
