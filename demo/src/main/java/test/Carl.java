package test;

import java.util.List;

public class Carl {
    //双指针
    public int findTarget(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {//闭区间
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //滑动窗口
    public int minSubArrayLen(int[] nums, int targetSum) {
        int len = nums.length, sum = 0, res = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < len; j++) {
            sum += nums[j];
            while (sum >= targetSum) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    //移除链表元素
    public ListNode removeElements(ListNode head,int target){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next !=null){
            if (cur.next.val == target){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

}
