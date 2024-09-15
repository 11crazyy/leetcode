package test;

public class IsHappy {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(bitSquareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    public int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
