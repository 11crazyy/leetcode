package test;

public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        if (n == 1) {
            return result;
        }
        for (int i = 0; i < n - 1; i++) {
            StringBuilder builder = new StringBuilder();
            int start = 0, pos = 0;
            int len = result.length();
            while (pos < len) {
                while (pos < len && result.charAt(start) == result.charAt(pos)) {
                    pos++;
                }
                builder.append(pos - start).append(result.charAt(start));
                start = pos;
            }
            result = builder.toString();
        }
        return result;
    }
}
