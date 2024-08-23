package test;

public class TwoNumDivide {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int flag = 1;
        if (dividend < 0) {
            flag = -flag;
            dividend = -dividend;
        }
        if (divisor < 0) {
            flag = -flag;
            divisor = -divisor;
        }
        if (dividend < divisor) {
            return 0;
        }
        int result = 0;
        while (dividend >= divisor) {
            int multiple = 1;
            int temp = divisor;
            while (dividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividend -= temp;
            result += multiple;
        }
        if (flag == -1) {
            return -result;
        }
        return result;
    }
}
