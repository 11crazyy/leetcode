package test;

public class MaxVowels {
    public int maxVowels(String s, int k) {
        //滑动窗口 入-更新-出
        int max = 0, vowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) vowels++;
            if (i < k - 1) continue;
            max = Math.max(vowels, max);
            int t = i - k + 1;
            if (isVowel(s.charAt(t))) vowels--;
        }
        return max;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
