package test;

import java.util.*;

public class Stack {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int num = temperatures[i];
            while (!stack.isEmpty() && num >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n * 2 - 1; i >= 0; i--) {
            int num = nums[i % n];
            while (!deque.isEmpty() && num >= deque.peek()) {
                deque.pop();
            }
            if (!deque.isEmpty() && i < n) {
                res[i] = deque.peek();
            }
            deque.push(num);
        }
        return res;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = stack.dailyTemperatures(temperatures);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] numsAns = new int[nums1.length];
        Arrays.fill(numsAns, -1);
        Map<Integer, Integer> ids = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            ids.put(nums1[i], i);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums2[i] >= deque.peek()) {
                deque.pop();
            }
            if (!deque.isEmpty() && ids.containsKey(nums2[i])) {
                numsAns[ids.get(nums2[i])] = deque.peek();
            }
            deque.push(nums2[i]);
        }
        return numsAns;
    }
}
