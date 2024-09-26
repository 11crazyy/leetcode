package test;

import java.util.*;

public class RandomizedSet {
    //变长数组查找 哈希表插入删除
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        //val不存在时返回true 否则返回false
        if (map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        list.add(val);//在数组末尾添加元素
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        //val不存在时返回false 否则返回true
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last,index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        //随机返回现有集合中的一个元素
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
