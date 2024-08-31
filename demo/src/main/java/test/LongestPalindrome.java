package test;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        //偶数和+奇数-1的和(+1)
        int sum = 0;
        int[] res = new int[128];
        for (char c : s.toCharArray()) {
            res[c]++;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] % 2 == 0) {
                sum += res[i];
            } else {
                sum += (res[i] - 1);
            }
        }
        return sum == s.length() ? sum : (sum + 1);
    }
}
