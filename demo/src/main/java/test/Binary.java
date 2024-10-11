package test;

import java.util.*;

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

    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = Arrays.stream(candies).max().getAsInt();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (children(candies, mid) >= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public long children(int[] candies, int num) {
        long res = 0;
        for (int candy : candies) {
            res += candy / num;
        }
        return res;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        //排序后最小的k个数与最大的k个数匹配
        Arrays.sort(nums);
        int left = 0, right = nums.length / 2 + 1;//开区间
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            //判断mid个数是否能匹配
            if (check(nums, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left * 2;
    }

    public boolean check(int[] nums, int k) {//0-2 1-3 k对
        for (int i = 0; i < k; i++) {
            if (nums[i] * 2 > nums[nums.length - k + i]) {
                return false;
            }
        }
        return true;
    }

    public int maxPointsInsideSquare(int[][] points, String s) {
        int[] min1 = new int[26];
        int min2 = Integer.MAX_VALUE;
        Arrays.fill(min1, Integer.MAX_VALUE);
        for (int i = 0; i < points.length; i++) {
            int x = Math.abs(points[i][0]);
            int y = Math.abs(points[i][1]);
            int d = Math.max(x, y);
            int j = s.charAt(i) - 'a';
            if (d < min1[j]) {
                min2 = Math.min(min2, min1[j]);//更新第二小的距离(最小的次小的距离) 即为边长
                min1[j] = d;//每个字母的最小距离
            } else if (d < min2) {
                min2 = d;//第二小的距离
            }
        }
        int res = 0;
        for (int i : min1) {
            if (i < min2) {
                res++;//计算满足的点有几个
            }
        }
        return res;
    }

    public int minTime(int[] time, int m) {
        if (time.length < m) {
            return 0;
        }
        int low = 0, high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = (low + high) / 2;
            if (check(time,mid,m)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean check(int[] time,int mid,int m){//mid是作业量最多的最小时间 m是总时间
    }

}

