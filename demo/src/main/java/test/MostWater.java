package test;

public class MostWater {
    public int maxArea(int[] height) {
        int begin = 0;
        int end = height.length - 1;
        int max = 0;
        while (begin<=end){
            int area = (end - begin)*Math.min(height[begin],height[end]);
            max = Math.max(area, max);
            if (height[begin] < height[end]){
                begin ++;
            }else {
                end --;
            }
        }
        return max;
    }
}
