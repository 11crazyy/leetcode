package test;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0], minProduct = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxProduct;
            maxProduct = Math.max(Math.max(maxProduct * nums[i], minProduct * nums[i]), nums[i]);
            minProduct = Math.min(Math.min(temp * nums[i], minProduct * nums[i]), nums[i]);
            ans = Math.max(ans, maxProduct);
        }
        return ans;
    }
}
