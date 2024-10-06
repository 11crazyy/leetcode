package test;

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
    public int smallestDifference(int[] a, int[] b) {
        
    }
}
