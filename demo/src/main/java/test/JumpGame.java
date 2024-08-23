package test;

public class JumpGame {
    public int jump(int[] nums) {
        //得到可以抵达的所有位置  比较这些位置对应的值  跳到下一次能到达更远的地方的位置  每跳一次jumpTime++
        int maxPos = 0;
        int end = 0;
        int jumpTime = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end){
                end = maxPos;
                jumpTime++;
            }
        }
        return jumpTime;
    }
}
