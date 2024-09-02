package test;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        //sum-index==citation[index]
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (n - i <= citations[i]) {
                return n - i;
            }
        }
        return 0;
    }
}
