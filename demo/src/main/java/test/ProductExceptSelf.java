package test;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //前缀积*后缀积
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);
        int beforeSum = 1, afterSum = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            answer[i] *= beforeSum;
            answer[j] *= afterSum;
            beforeSum *= nums[i];
            afterSum *= nums[j];
        }
        return answer;
    }
}
