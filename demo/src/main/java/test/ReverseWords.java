package test;

public class ReverseWords {
    public String reverseWords(String s) {
        //按空格分隔，并去除空字符串 反转字符串数组 使用String.join拼接
        String[] str = s.trim().split("\\s+");
        for (int i = 0; i < str.length / 2; i++) {
            String t = str[i];
            str[i] = str[str.length - i - 1];
            str[str.length - i - 1] = t;
        }
        return String.join(" ", str);
    }
}
