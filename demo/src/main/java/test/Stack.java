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

    public int minFlips(int[][] grid) {
        //翻转任意格子后 每一行都是回文或每一列都是回文 回文：总数为偶数时01个数也偶数 总数为奇数时0奇1偶或0偶1奇
        int m = grid.length;
        int n = grid[0].length;
        int diff = 0;
        for (int[] row : grid) {
            for (int i = 0; i < n / 2; i++) {
                if (row[i] != row[n - 1 - i]) {
                    diff++;
                }
            }
        }
        int diff1 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                if (grid[j][i] != grid[m - 1 - j][i]) {
                    diff1++;
                }
            }
        }
        return Math.min(diff, diff1);
    }

    public int[] nextLargerNodes(ListNode head) {
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        int[] res1 = new int[len];
        int t = 0;
        ListNode node = head;
        while (node != null) {
            res1[t++] = node.val;
            node = node.next;
        }
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && res1[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            }
            stack.push(res1[i]);
        }
        return res;
    }

    public int maxWidthRamp(int[] nums) {
        //第一次遍历构建单调递减栈 第二次遍历找到最大宽度
        int n = nums.length, res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deque.isEmpty() || nums[deque.peek()] > nums[i]) {
                deque.push(i);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[i]) {
                int num = deque.pop();
                res = Math.max(res, i - num);
            }
        }
        return res;
    }

    public int[] sortByBits(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            res[i] %= 10000000;
        }
        return res;
    }

    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < land.length; j++) {
            for (int k = 0; k < land[0].length; k++) {
                if (land[j][k] == 0) {
                    list.add(dfs(land, j, k));
                }
            }
        }
        int[] res = new int[list.size()];
        for (int num : list) {
            res[i++] = num;
        }
        Arrays.sort(res);
        return res;
    }

    public int dfs(int[][] land, int x, int y) {
        if (x < 0 || y < 0 || x >= land.length || y >= land[0].length || land[x][y] != 0) {
            return 0;
        }
        land[x][y] = 1;
        int count = 1;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                count += dfs(land, i, j);
            }
        }
        return count;
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = smooth(img, i, j);
            }
        }
        return res;
    }

    public int smooth(int[][] img, int i, int j) {
        int m = img.length, n = img[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        int count = 0, cnt = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k < 0 || l < 0 || k >= m || l >= n) {
                    cnt++;
                    continue;
                }
                count += img[k][l];
            }
        }
        return count / (9 - cnt);
    }
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int cities = isConnected.length;
            boolean[] visited = new boolean[cities];
            int provinces = 0;
            for (int i = 0; i < cities; i++) {
                if (!visited[i]) {
                    dfs(isConnected, visited, cities, i);
                    provinces++;
                }
            }
            return provinces;
        }

        public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
            for (int j = 0; j < cities; j++) {
                if (isConnected[i][j] == 1 && !visited[j]) {//i和j连通且j未被访问
                    visited[j] = true;
                    dfs(isConnected, visited, cities, j);
                }
            }
        }
    }
}



















