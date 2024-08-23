package test;

public class Mysqrt {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        int left = 0,right = x;
        while (left <= right){
            int mid = (left + right)/2;
            long result = (long) mid*mid;
            if (result == x){
                return mid;
            }else if (result < x){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }
}
