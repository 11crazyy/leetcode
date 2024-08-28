package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindKClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //删掉len-k个元素
        List<Integer> result = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        for (int i = 0; i < arr.length - k; i++) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
