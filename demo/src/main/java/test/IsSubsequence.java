package test;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if ("".equals(s)) {
            return true;
        }
        int n = s.length(), index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                n--;
                index++;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
