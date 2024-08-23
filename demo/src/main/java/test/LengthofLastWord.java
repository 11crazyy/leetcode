package test;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) return 0;
        //从后往前跳过空格 计算最后一个单词长度
        int len = s.length();
        int i = len - 1, sum = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            sum++;
        }
        return sum;
    }
}
