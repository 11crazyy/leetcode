package test;

public class DeleteRepeatII {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;;
        if (len <= 2){
            return len;
        }
        int fast = 2,slow = 2;//fast指针用于遍历原数组，slow指针用于记录新数组
        while (fast < nums.length){
            if (nums[fast]!=nums[slow-2]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
