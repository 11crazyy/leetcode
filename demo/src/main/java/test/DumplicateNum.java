package test;

public class DumplicateNum {
    public int findDuplicate(int[] nums) {
        //初始化快慢指针
        int slow = nums[0], fast = nums[0];
        //第一次相遇
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        //将慢指针重置为起点位置
        slow = nums[0];
        //找到循环入口，即重复元素
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
