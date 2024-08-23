package test;

import java.util.Arrays;

public class NextPailie {
    public void nextPermutation(int[] nums) {
        //从后往前找第一个升序组合
        int len = nums.length;
        int n = len - 1;
        int index = -1;
        while (n > 0) {
            if (nums[n] > nums[n - 1]) {
                index = n - 1;
                break;
            }
            n--;
        }
        //没有找到 说明数组降序 则反转数组
        if (index == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        //找第一个大于nums[index]的数nums[index1]
        int index1 = index;
        for (int i = len - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                index1 = i;
                break;
            }
        }
        //交换nums[index]和nums[index1]
        int t = nums[index1];
        nums[index1] = nums[index];
        nums[index] = t;
        //将nums[index1+1]-a[n]按升序排列
        Arrays.sort(nums, index + 1, len);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
