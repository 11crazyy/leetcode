package test;

public class FindFirstIndex {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        char[] char1 = haystack.toCharArray();
        char[] char2 = needle.toCharArray();
        int len1 = haystack.length();
        int len2 = needle.length();
        int j = 0;
        for (int i = 0; i <= len1 - len2; i++) {
            for (j = 0; j < len2; j++) {
                if (char1[i +j]!=char2[j]){
                    break;
                }
            }
            if (j == len2){
                return i;
            }
        }
        return -1;
    }
}
