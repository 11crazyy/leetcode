package test;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FindKClosest findKClosest = new FindKClosest();
        List<Integer> res = findKClosest.findClosestElements(new int[]{-2,-1,1,2,3,4,5},7,3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}