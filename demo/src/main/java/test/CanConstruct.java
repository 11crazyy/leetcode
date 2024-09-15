package test;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Character c : ransomNote.toCharArray()) {
            map.put(c - 'a', map.getOrDefault(c - 'a', 0) + 1);
        }
        for (Character c : magazine.toCharArray()) {
            if (map.containsKey(c - 'a')) {
                if (map.get(c - 'a') == 1) {
                    map.remove(c - 'a');
                } else {
                    map.put(c - 'a', map.get(c - 'a') - 1);
                }
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        CanConstruct canConstruct = new CanConstruct();
        System.out.println(canConstruct.canConstruct("a", "b"));
    }
}
