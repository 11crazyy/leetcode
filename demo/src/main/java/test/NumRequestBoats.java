package test;

import java.util.Arrays;

public class NumRequestBoats {
    //贪心+双指针
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int minNum = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                minNum++;
            } else {
                minNum++;
                right--;
            }
        }
        return minNum;
    }
}
