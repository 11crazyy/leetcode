package test;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        //利用单调栈获得结果 stringbuilder得到结果 移除前导0 返回结果
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !characters.isEmpty() && characters.peek() > num.charAt(i)) {
                characters.pop();
                k--;
            }
            characters.push(num.charAt(i));
        }
        while (k > 0) {
            characters.pop();
            k--;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : characters) {
            builder.append(c);
        }
        //移除前导0
        while (builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
