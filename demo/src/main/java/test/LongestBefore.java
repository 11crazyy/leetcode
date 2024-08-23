package test;

public class LongestBefore {
    //字符串数组最长前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.equals("")|| strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix,strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private String commonPrefix(String prefix, String str) {
        int len = Math.min(prefix.length(),str.length());
        int index = 0;
        while (index < len&&str.charAt(index)==prefix.charAt(index)){
            index++;
        }
        return str.substring(0,index);
    }
}
