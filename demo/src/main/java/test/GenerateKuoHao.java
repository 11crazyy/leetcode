package test;

import java.util.ArrayList;
import java.util.List;

public class GenerateKuoHao {
    public List<String> generateParenthesis(int n) {
        //回溯算法 生成n对有效的括号
        List<String> list = new ArrayList<>();
        backtrack(list,0,0,n,new StringBuilder());
        return list;
    }
    public void backtrack(List<String> list,int leftCount,int rightCount,int sum,StringBuilder stringBuilder){
        if (stringBuilder.length()==sum*2){
            list.add(stringBuilder.toString());
        }
        if (leftCount < sum){
            stringBuilder.append('(');
            backtrack(list,leftCount+1,rightCount,sum,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (rightCount < leftCount){
            stringBuilder.append(')');
            backtrack(list,leftCount,rightCount+1,sum,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
