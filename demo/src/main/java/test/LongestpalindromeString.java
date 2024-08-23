package test;

public class LongestpalindromeString {
    public String longestPalindrome(String s) {
        int maxLen = 1;
        int begin = 0;
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j >= len){
                    break;
                }
                if (s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else if (j - i < 3){
                    dp[i][j] = true;
                }else {
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j]&&L > maxLen){
                    begin = i;
                    maxLen = L;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
