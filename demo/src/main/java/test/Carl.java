package test;

import java.util.Arrays;
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
    public ListNode removeElements(ListNode head, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == target) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public int removeElement(int[] nums, int val) {
        int res = 0, t = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                res++;
            } else {
                ans[t++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
        return nums.length - res;
    }

    public static void main(String[] args) {
        Carl carl = new Carl();
        int[] nums = {3, 2, 3};
        carl.majorityElement(nums);
    }

    public int majorityElement(int[] nums) {
        int t = nums.length / 2;
        Arrays.sort(nums);
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                n++;
                if (n > t) {
                    return nums[i];
                }
            } else n = 1;
        }
        return nums[0];
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }

    public String largestGoodInteger(String num) {
        int cnt = 1;
        char c = 0;
        for(int i = 1;i < num.length();i++){
            char t = num.charAt(i);
            if(t != num.charAt(i-1)){
                cnt=1;
            }else{
                cnt++;
                if(cnt==3 && t > c){
                    c = t;
                }
            }
        }
        return c == 0?"":String.valueOf(c).repeat(3);
    }

    public int maxProfit(int[] prices) {
        int max = 0,min = 9999;
        for(int i = 0;i < prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
