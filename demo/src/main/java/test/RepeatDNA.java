package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        if (s.length() < 10) return result;
        String s1 = s.substring(0, 10);
        map.put(s1, map.getOrDefault(s1, 0) + 1);
        for (int i = 1; i <= s.length() - 10; i++) {
            String s2 = s.substring(i, i + 10);
            map.put(s2, map.getOrDefault(s2, 0) + 1);
            if (map.get(s2) == 2) {
                result.add(s2);
            }
        }
        return result;
    }
}
