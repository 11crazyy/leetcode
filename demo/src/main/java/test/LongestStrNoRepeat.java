package test;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStrNoRepeat {
    //最长子串的长度
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), len++);
            }else {
                map.clear();
                len = 0;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}
