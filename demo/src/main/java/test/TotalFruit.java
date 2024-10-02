package test;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //得到水果种类为2的滑动窗口，再计算窗口的最大长度
        for (int j = 0; j < fruits.length; j++) {//右边界
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while (map.size() > 2) {//处理窗口水果种类大于2的情况
                map.put(fruits[i], map.get(fruits[i]) - 1);//左边界右移
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);//如果左边界的水果数量为0，删除
                }
                i++;//左边界右移
            }
            sum = Math.max(sum, j - i + 1);//计算窗口的最大长度
        }
        return sum;
    }
}
