package test;

public class SortColors {
    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                int t = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = t;
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if (nums[i]==1){
                int t = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = t;
                ptr++;
            }
        }
    }
}
