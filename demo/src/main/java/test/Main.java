package test;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}