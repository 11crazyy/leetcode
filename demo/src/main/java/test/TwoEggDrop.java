package test;

public class TwoEggDrop {
    private static final int[] mem = new int[1001];

    public int twoEggDrop(int n) {
        if (n == 0 ){
            return 0;
        }
        if (mem[n] > 0){
            return mem[n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res,Math.max(i,twoEggDrop(n-i)+1));
        }
        mem[n] = res;
        return res;
    }
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            // Check if `mid` is the peak
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }

            // If we're in the increasing part of the mountain
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;  // move right
            } else {
                r = mid;  // move left
            }
        }
        return l;  // `l` and `r` converge to the peak index
    }

}
