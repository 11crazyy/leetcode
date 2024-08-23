package test;

import java.util.ArrayList;
import java.util.List;

public class IpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        backtracking(result, s, 0, new StringBuilder(), 0);
        return result;
    }

    public void backtracking(List<String> result, String string, int pointNum, StringBuilder builder, int startIndex) {
        if (pointNum == 3) {
            //已经有三个点，那么检查剩余的字符串是否符合
            String lastPart = string.substring(startIndex);
            if (isVaildPart(lastPart)) {
                builder.append(lastPart);
                result.add(builder.toString());
            }
            return;
        }
        for (int i = startIndex; i < string.length(); i++) {
            String s = string.substring(startIndex, i + 1);
            if (isVaildPart(s)) {
                int len = builder.length();
                builder.append(s).append('.');
                backtracking(result, string, pointNum + 1, builder, i + 1);
                builder.delete(len, builder.length());
            } else break;
        }
    }

    public boolean isVaildPart(String s) {
        if (s.length() > 3 || s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
