package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
