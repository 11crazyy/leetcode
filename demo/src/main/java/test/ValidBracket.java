package test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidBracket {
    //key('}',')',']')加到stack 遇到('(','{','[')时弹出相应的value 最后判断stack是否为空
    public boolean isValid(String s) {
        if (s.length() % 2 != 0){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (deque.isEmpty() || deque.peek() != map.get(ch)){
                    return false;
                }
                deque.pop();
            }else {
                deque.push(ch);
            }
        }
        return deque.isEmpty();
    }
}
