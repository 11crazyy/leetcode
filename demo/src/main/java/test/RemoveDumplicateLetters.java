package test;

public class RemoveDumplicateLetters {
    //    public String removeDuplicateLetters(String s) {
//        //用res保存结果 遍历s中的元素 如果s中元素在res中出现过，continue 如果res[i]<res[i-1]且res[i]在s中后面还有元素 则删除res[i]
//        //如果res[i]>res[i-1] 则直接添加
//        int[] appeartimes = new int[26];
//        boolean[] visited = new boolean[26];
//        StringBuilder builder = new StringBuilder();
//        //记录元素出现的次数
//        for (char c : s.toCharArray()) {
//            appeartimes[c - 'a']++;
//        }
//        //去除重复元素
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            appeartimes[c - 'a']--;
//            if (visited[c - 'a']) {
//                continue;
//            }
//            //如果res[i]<res[i-1]且res[i]在s中后面还有元素 则删除res[i]
//            while (!builder.isEmpty() && c < builder.charAt(builder.length() - 1) && appeartimes[builder.charAt(builder.length() - 1) - 'a'] > 0) {
//                visited[builder.charAt(builder.length() - 1) - 'a'] = false;
//                builder.deleteCharAt(builder.length() - 1);
//            }
//            //直接添加元素
//            builder.append(c);
//            visited[c - 'a'] = true;
//        }
//        return builder.toString();
//    }
    public String removeDuplicateLetters(String s) {
        int[] appTimes = new int[26];//出现次数
        boolean[] visited = new boolean[26];//是否出现在结果中
        StringBuilder builder = new StringBuilder();//保存符合条件的结果
        //记录元素出现次数
        for (char c : s.toCharArray()) {
            appTimes[c - 'a']++;
        }
        //去除重复元素
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            appTimes[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!builder.isEmpty() && c < builder.charAt(builder.length() - 1) && appTimes[builder.charAt(builder.length() - 1) - 'a'] > 0) {
                visited[builder.charAt(builder.length() - 1) - 'a'] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append(c);
            visited[c - 'a'] = true;
        }
        return builder.toString();
    }
}
