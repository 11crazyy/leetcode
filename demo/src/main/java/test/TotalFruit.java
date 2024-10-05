package test;

import java.util.Arrays;
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

    public int maximumBeauty(int[] nums, int k) {
        //nums[right] - nums[left] > 2k
        int left = 0;
        int res = 0;
        Arrays.sort(nums);
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int numberOfSubstrings(String s) {
        int res = 0;
        //双指针 找l-r区间内包含abc的最小子串 res + = len - r
        //l右移，找下一个包含abc的最小子串
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() == 3) {
                res += s.length() - right;
                char cl = s.charAt(left);
                map.put(cl, map.get(cl) - 1);//更新map,移除left对应的元素
                if (map.get(cl) == 0) {
                    map.remove(cl);
                }
                left++;//左指针右移
            }
        }
        return res;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //双指针 找l-r区间内最大的乘积小于k的子数组 res+=r-l+1
        int res = 0;
        if (k <= 1) {
            return 0;
        }
        int left = 0, right = 0, sum = 1;
        for (right = 0; right < nums.length; right++) {
            sum *= nums[right];
            while (sum >= k) {
                sum /= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }

    public int beautifulBouquet(int[] flowers, int cnt) {
        int res = 0, left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < flowers.length; right++) {
            map.put(flowers[right], map.getOrDefault(flowers[right], 0) + 1);
            while (map.get(flowers[right]) > cnt) {
                map.put(flowers[left], map.get(flowers[left]) - 1);
                if (map.get(flowers[left]) == 0) {
                    map.remove(flowers[left]);
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        //前缀和
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//初始化前缀和为0的个数为1
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - goal)) {
                res += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] <= target) {
                res += r - l;
                l++;
            } else {
                r--;
            }
            res %= 1000000007;
        }
        return res % 1000000007;
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int fullA = capacityA, fullB = capacityB;
        int left = 0, right = plants.length - 1;
        int waterTime = 0;
        while (left < right) {
            if (plants[left] > capacityA) {//需要补水
                waterTime++;
                capacityA = fullA;
            }
            capacityA -= plants[left];//浇水
            left++;
            if (plants[right] > capacityB) {//需要补水
                waterTime++;
                capacityB = fullB;
            }
            capacityB -= plants[right];//浇水
            right--;
        }
        if (left == right) {
            if (plants[left] > capacityA && plants[left] > capacityB) {
                waterTime++;
            }
        }
        return waterTime;
    }

    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (map.containsKey(a * 2) || (a % 2 == 0 && map.containsKey(a / 2))) {
                return true;
            } else {
                map.put(a, 1);
            }
        }
        return false;
    }

}
