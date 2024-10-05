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
}
