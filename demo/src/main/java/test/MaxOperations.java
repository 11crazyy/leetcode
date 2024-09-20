package test;

import java.util.Arrays;

public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int left = 0,right = nums.length-1;
        while(left < right){
            if(nums[left] + nums[right] == k){
                res++;
                left++;
                right--;
            }else if(nums[left] + nums[right] < k){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxOperations maxOperations = new MaxOperations();
        int res = maxOperations.maxOperations(new int[]{3,1,3,4,3}, 6);
        System.out.println(res);
    }
}
