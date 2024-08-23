package test;

public class StringToNum {
    public int myAtoi(String s) {
        int index = 0;
        int len = s.length();

        // 处理前导空格
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }

        // 初始标志为正数
        int flag = 1;

        // 处理正负号
        if (index < len && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            flag = s.charAt(index++) == '+' ? 1 : -1;
        }

        // 初始化结果
        int sum = 0;

        // 处理数字
        while (index < len && Character.isDigit(s.charAt(index))) {
            int num = s.charAt(index) - '0';

            // 检查整型溢出
            if (flag == 1 && (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && num > 7))) {
                return Integer.MAX_VALUE;
            } else if (flag == -1 && (-sum < Integer.MIN_VALUE / 10 || (-sum == Integer.MIN_VALUE / 10 && -num < -8))) {
                return Integer.MIN_VALUE;
            }

            sum = sum * 10 + num;
            index++;
        }

        return sum * flag;
    }
}
