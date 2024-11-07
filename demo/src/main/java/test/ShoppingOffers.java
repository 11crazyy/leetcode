package test;

import java.util.*;

public class ShoppingOffers {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n + 1];//dp[i]表示前i个字符的解码方法数
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            String substring = s.substring(i - 1, i);
            Integer integer = Integer.valueOf(substring);
            if (integer >= 1 && integer <= 9) {
                dp[i] += dp[i - 1];
            }
            Integer s2 = Integer.parseInt(s.substring(i - 2, i));
            if (s2 >= 10 && s2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            String s1 = s.substring(i - 1, i);
            Integer integer = Integer.valueOf(s1);
            if (integer >= 1 && integer <= 9) {
                dp[i] += dp[i - 1];
            }
            Integer integer1 = Integer.valueOf(s.substring(i - 2, i));
            if (integer1 >= 10 && integer1 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];//dp[i]表示前i个字符的最小美丽子串数
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        Set<String> beautifulSet = beautifulSet(s);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (sub.charAt(0) == '0') {
                    continue;
                }
                if (beautifulSet.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }

    private Set<String> beautifulSet(String substring) {
        //二进制表示 5的幂 不含前导0
        Set<String> set = new HashSet<>();
        long num = 1;
        while (num <= (1L << 15)) {
            set.add(Long.toBinaryString(num));
            num *= 5;
        }
        return set;
    }

    public boolean judgeSquareSum(int c) {
        //c=a*2+b*2
        if (c == 0) {
            return true;
        }
        long low = 0, high = (long) Math.sqrt(c);
        while (low <= high) {
            long sum = low * low + high * high;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                low++;
            } else high--;
        }
        return false;
    }

    public int minSteps(int n) {
        //n为质数只能复制1次然后一直粘贴 n为合数可以分解为n=ab a和b都是合数
        int step = steps(n);
        return step;
    }

    public int steps(int n) {
        int factor = 1;
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                factor = i;
            }
        }
        if (factor == 1) {//n为质数
            return n;
        }
        return factor + steps(n / factor);
    }

    public boolean canReach(int[] arr, int start) {
        //如果两次跳到同一个位置 返回false
        boolean[] reached = new boolean[arr.length];//标志位
        return dfs(arr, start, reached);
    }

    public boolean dfs(int[] arr, int start, boolean[] reached) {
        if (start < 0 || start >= arr.length || reached[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        reached[start] = true;
        return dfs(arr, start + arr[start], reached) || dfs(arr, start - arr[start], reached);
    }

    public static void main(String[] args) {
        ShoppingOffers shoppingOffers = new ShoppingOffers();
        int t = shoppingOffers.longestCommonSubarry(new int[]{1, 2}, new int[]{1, 2});
        System.out.println(t);
    }

    Map<Long, Integer> memo = new HashMap<>();

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            index = i == 0 || nums[i] - nums[i - 1] != 1 ? 1 : index++;
            if (index >= k) {
                res[i - k + 1] = nums[i];
            }
        }
        return res;
    }

    public String[] maxValidParenthesesStr(String s) {
        // write code here
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String[] res = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int t = Math.min(map.get(')'), map.get('('));
        return res;
    }

    public int integerReplacement(int n) {
        return dfs((long) n);
    }

    public int dfs(long n) {
        if (n == 1) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = 0;
        if (n % 2 == 0) {
            res = dfs(n / 2) + 1;
        } else {
            res = Math.min(dfs(n + 1), dfs(n - 1)) + 1;
        }
        memo.put(n, res);
        return res;
    }

    private final Map<Integer, Integer> map = new HashMap<>();

    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) {
            return y - x;
        }
        if (map.containsKey(x)) {
            return map.get(x);
        }
        int ans = x - y;
        ans = Math.min(ans, 1 + minimumOperationsToMakeEqual(x / 11, y) + x % 11);
        ans = Math.min(ans, 1 + minimumOperationsToMakeEqual(x / 11 + 1, y) + 11 - x % 11);
        ans = Math.min(ans, 1 + minimumOperationsToMakeEqual(x / 5, y) + x % 5);
        ans = Math.min(ans, 1 + minimumOperationsToMakeEqual(x / 5 + 1, y) + 5 - x % 5);
        map.put(x, ans);
        return ans;
    }

    public int longestCommonSubarry(int[] A, int[] B) {
        // write code here
        int res = 0;
        int sum = 0;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                sum++;
                i++;
                j++;
            } else {
                sum = 0;
                i++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public int leafPairs(TreeNode root, int k) {
        // write code here
        return dfs(root, 0, k);
    }

    public int dfs(TreeNode node, int sum, int k) {
        if (node == null) {
            return 0;
        }
        if (sum == k) {
            return 0;
        }
        if (node.left != null) {
            return dfs(node.left, sum + 1, k);
        }
        if (node.right != null) {
            return dfs(node.right, sum + 1, k);
        }
        return sum;
    }

    public int[] resultsArray1(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Arrays.fill(res, -1);
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            t = (i == 0 || nums[i] - nums[i - 1] == 1) ? t + 1 : 1;
            if (t >= k) {
                res[i - k + 1] = nums[i];
            }
        }
        return res;
    }

    public void getNext(int[] next, String s) {
        int j = 0;//前缀末尾
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {//前后缀不匹配
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
