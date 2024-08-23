package test;

import com.sun.source.tree.BreakTree;

public class isPalindrom {
    public boolean isPalindrome(int x) {
        int y = x;
        if (x < 0) {
            return false;
        }
        int sum = 0;
        while (x > 0) {
            int modNum = x % 10;
            sum = sum * 10 + modNum;
            x = x / 10;
        }
        return sum == y;
    }
}
