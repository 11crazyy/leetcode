package test;

import java.util.ArrayList;
import java.util.List;

public class ZChange {
    public String convert(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int index = 0;
        int flag = -1;
        for (char c:s.toCharArray()){
            rows.get(index).append(c);
            if (index == 0 || index == numRows -1){
                flag = -flag;
            }
            index += flag;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder row : rows) {
            stringBuilder.append(row);
        }
        return stringBuilder.toString();
    }
}
