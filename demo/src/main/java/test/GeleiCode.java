package test;

import java.util.ArrayList;
import java.util.List;

public class GeleiCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add((i >> 1) ^ i);
        }
        return result;
    }
}
