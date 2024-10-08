package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTime {
    public long minimumTime(int[] time, int totalTrips) {
        long minT = 1;
        long maxT = 0;//初始化时间 为二分做准备
        for (int t : time) {
            maxT = Math.max(maxT, (long) t * totalTrips);
        }
        while (minT < maxT) {
            long mid = (minT + maxT) / 2;    //mid是每辆车的总用时
            long sum = 0;//计算mid时间内能完成的任务总数
            for (int t : time) {
                sum += mid / t;
            }
            if (sum >= totalTrips) {
                maxT = mid;
            } else {
                minT = mid + 1;
            }
        }
        return minT;
    }

    public int findUnsortedSubarray(int[] nums) {
        //从左到右第一个不符合的为right 从右到左第一个不符合的为left
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
            if (nums[nums.length - i - 1] > min) {
                left = nums.length - i - 1;
            } else {
                min = nums[nums.length - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    public int findLUSlength(String[] strs) {
        int res = -1;
        Map<String, Integer> countMp = new HashMap<>();
        for (String str : strs) {
            countMp.put(str, countMp.getOrDefault(str, 0) + 1);
        }
        //外层循环遍历字符串数组，作为特殊序列 内层循环判断是否是独有的子序列并计算最长子序列的长度
        for (String str : strs) {
            if (countMp.get(str) > 1) {
                continue;
            }
            boolean flag = true;
            for (String s : strs) {
                if (!s.equals(str) && isSubseq(s, str)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = Math.max(res, str.length());
            }
        }
        return res;
    }

    public boolean isSubseq(String a, String b) {//b是否是a的子串
        int l1 = 0, l2 = 0;
        while (l2 < b.length()) {
            if (l1 == a.length()) {
                return false;
            }
            if (a.charAt(l1) == b.charAt(l2)) {
                l1++;
                l2++;
            } else {
                l1++;
            }
        }
        return true;
    }

    public int numFriendRequests(int[] ages) {
        //年龄在(0.5*age+7,age]的人可以发出好友请求
        Arrays.sort(ages);
        int left = 0, right = 0;
        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] <= 14) {
                continue;
            }
            while (ages[left] <= 0.5 * ages[i] + 7) {
                left++;
            }
            while (right + 1 < ages.length && ages[right + 1] <= ages[i]) {
                right++;
            }
            res += right - left;
        }
        return res;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int l1 = 0, l2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                l2 = i;
            }
            if (nums[i] >= left) {
                l1 = i;
            }
            res += l1 - l2;
        }
        return res;
    }

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            map.put(paths.get(i).get(0), 1);
        }
        for (int i = 0; i < paths.size(); i++) {
            if (!map.containsKey(paths.get(i).get(1))) {
                return paths.get(i).get(1);
            }
        }
        return "";

    }
}
