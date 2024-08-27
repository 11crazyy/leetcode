package test;

import java.util.Arrays;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        //用俩数组记录单词出现的次数
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            //第一个窗口
            s2Count[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Count, s2Count)) return true;
        //滑动窗口比较俩数组是否相等
        for (int i = s1.length(); i < s2.length(); i++) {
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        return false;
    }
}
