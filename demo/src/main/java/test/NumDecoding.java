package test;

import java.util.ArrayList;
import java.util.List;

public class NumDecoding {
    public int numDecodings(String s) {
        int n = s.length();
        if (s == null || n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n + 1];//1-n+1个字符的解码方式
        dp[0] = 1;//空字符的解码方式
        dp[1] = 1;//一个字符的解码方式
        for (int i = 2; i < n + 1; i++) {
            int oneDig = Integer.parseInt(s.substring(i - 1, i));
            int twoDig = Integer.parseInt(s.substring(i - 2, i));
            if (oneDig >= 1 && oneDig <= 9) {
                dp[i] = dp[i - 1];
            }
            if (twoDig >= 10 && twoDig <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
