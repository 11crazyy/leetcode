package test;

import java.util.Arrays;
import java.util.Map;

public class Binary {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nums1[i];
        }
        int max = 0, sum = 0;
        Arrays.sort(ans);
        for (int i = 0; i < nums1.length; i++) {
            int res1 = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + res1) % 1000000007;
            int index = binary(ans, nums2[i]);//找到最接近nums2[i]的数 需要把nums1[i]换成ans[index]
            if (index < nums1.length) {
                max = Math.max(max, res1 - (ans[index] - nums2[i]));//最大的差值
            }
            if (index > 0) {
                max = Math.max(max, res1 - (nums2[i] - ans[index - 1]));//最大的差值
            }
        }
        return (sum - max + 1000000007) % 1000000007;
    }

    public int binary(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (nums[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int middle = (low + high) / 2;
            if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int sumTime = 0, middle = 0;
        while (low < high) {
            middle = (low + high) / 2;
            for (int i = 0; i < piles.length; i++) {
                sumTime += (piles[i] + middle - 1) / middle;
            }
            if (sumTime > h) {
                low = middle + 1;
            } else {
                high = middle;
            }
            sumTime = 0;
        }
        return low;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt(), high = Arrays.stream(weights).sum();
        while (low < high) {
            int middle = (low + high) / 2;
            //需要能在days天内将所有货物运完
            int daySum = getDays(weights, middle);
            if (daySum < days) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    public int getDays(int[] weights, int res) {
        int ans = 0, sum = 0;
        for (int weight : weights) {
            if (sum + weight > res) {
                ans++;
                sum = weight;
            } else {
                sum += weight;
            }
        }

        return ans;
    }


    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1; // 最小速度
        int high = 10000000; // 设定 high 为一个足够大的值

        // 二分查找
        while (low < high) {
            int middle = (low + high) / 2;
            // 求需要的时间是否小于 hour
            double time = getTimes(dist, middle);
            if (time > hour) {
                low = middle + 1; // 速度太慢，增加速度
            } else {
                high = middle; // 速度足够快，尝试更低的速度
            }
        }

        // 在找到的 low 速度下验证总时间
        double finalTime = getTimes(dist, low);
        return finalTime > hour ? -1 : low; // 如果时间超出，返回 -1
    }

    public double getTimes(int[] dist, int speed) {
        double totalTime = 0.0; // 总时间
        for (int i = 0; i < dist.length; i++) {
            // 计算每段的时间
            if (i == dist.length - 1) {
                totalTime += (double) dist[i] / speed; // 最后一段可以直接除
            } else {
                totalTime += Math.ceil((double) dist[i] / speed); // 其他段向上取整
            }
        }
        return totalTime; // 返回总时间
    }

    public int hIndex(int[] citations) {
        int low = 0, high = citations.length;
        while (low < high) {
            int middle = (low + high) / 2;
            if (citations[citations.length - middle - 1] >= middle + 1) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}

