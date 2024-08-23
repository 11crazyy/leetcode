package test;

public class StringMultiple {
    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[m + n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = num1.charAt(n - i - 1) - '0';
                int y = num2.charAt(m - j - 1) - '0';
                result[i + j] += x * y;
            }
        }
        for (int i = 0,carry = 0; i < result.length; i++) {
            result[i] = result[i] + carry;
            carry = result[i] / 10;
            result[i] %= 10;
        }
        for (int i = result.length - 1; i >= 0 ; i--) {
            res.append(result[i]);
        }
        while (res.length() > 1 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        return res.toString();
    }

}
