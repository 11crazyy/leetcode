package test;

import java.util.HashMap;
import java.util.Map;

public class IntToLuoma {
    public String intToRoman(int num) {
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]){
                num -= values[i];
                builder.append(symbols[i]);
            }
            if (num == 0){
                break;
            }
        }
        return builder.toString();
    }
}
