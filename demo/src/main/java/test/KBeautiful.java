package test;

public class KBeautiful {
    public int divisorSubstrings(int num, int k) {
        int kVal = 0;
        String numStr = String.valueOf(num);
        for (int i = 0; i <= numStr.length() - k; i++) {
            //依次取得长度为k的子串
            String subStr = numStr.substring(i, i + k);
            int subNum = Integer.parseInt(subStr);
            //判断能否整除
            if (subNum != 0 && num % subNum == 0) {
                kVal++;
            }
        }
        return kVal;
    }
}
