package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestStrNoRepeat {
    //最长子串的长度
    public int lengthOfLongestSubstring(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        int max = 0;
//        int len = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))) {
//                map.put(s.charAt(i), len++);
//            }else {
//                map.clear();
//                len = 0;
//            }
//            max = Math.max(len, max);
//        }
//        return max;
        HashSet<Character> set = new HashSet<>();
        char[] ss = s.toCharArray();
        int res = 0;
        //外层循环扩展有边界 内层循环扩展左边界
        for (int left = 0, right = 0; right < s.length(); right++) {
            //考虑当前元素
            while (left <= right && set.contains(ss[right])) {
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
