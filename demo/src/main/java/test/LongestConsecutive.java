package test;

import java.util.HashMap;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        //用哈希表查找当前数字的前一个数是否存在，如果存在则跳过 否则计算连续长度
        int longestLen = 0, i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, i);
            i++;
        }
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int currentLen = 1;
                int currentNum = num;
                while (map.containsKey(currentNum + 1)) {
                    currentLen++;
                    currentNum++;
                }
                longestLen = Math.max(longestLen, currentLen);
            }
        }
        return longestLen;
    }
}
