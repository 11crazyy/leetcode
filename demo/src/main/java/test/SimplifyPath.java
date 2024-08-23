package test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] list = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String string : list) {
            if ("..".equals(string)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if ("".equals(string) || ".".equals(string)) {
                continue;
            } else {
                deque.offerLast(string);
            }
        }
        StringBuffer buffer = new StringBuffer();
        if (deque.isEmpty()) {
            buffer.append('/');
        } else {
            while (!deque.isEmpty()) {
                buffer.append('/');
                buffer.append(deque.pollFirst());
            }
        }
        return buffer.toString();
    }
}
