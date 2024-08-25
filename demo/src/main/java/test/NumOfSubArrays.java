package test;

public class NumOfSubArrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = threshold * k;
        int result = 0;
        int nums = 0;
        for (int i = 0; i < k; i++) {
            nums += arr[i];
        }
        if (nums >= sum) result++;
        for (int i = 1; i <= arr.length - k; i++) {
            nums = nums - arr[i - 1] + arr[i + k - 1];
            if (nums >= sum) result++;
        }
        return result;
    }
}
