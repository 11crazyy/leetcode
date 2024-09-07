package test;

import java.util.Arrays;

public class TianjiHourse {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[j]) {
                j++;
            }
        }
        return j;
    }
}
