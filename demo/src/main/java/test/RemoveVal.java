package test;

public class RemoveVal {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (fast < nums.length){
            if (nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        int result = slow;
        while (slow < nums.length){
            nums[slow] = '_';
            slow++;
        }
        return result;
    }
}
