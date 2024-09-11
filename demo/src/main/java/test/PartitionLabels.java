package test;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        //合并区间
        int[] last = new int[26];
        List<Integer> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end, last[chars[i] - 'a']);
            if (end == i) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
