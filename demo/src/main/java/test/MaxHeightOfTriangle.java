package test;

public class MaxHeightOfTriangle {

    public int maxHeightOfTriangle(int red, int blue) {
        //计算Math.max(红，蓝，。。。。)，（蓝，红，。。。）
        int h = Math.max(height(red, blue), height(blue, red));
        return h;
    }

    public int height(int a, int b) {
        //奇数行
        int odd = (int) Math.sqrt(a);
        int even = (int) ((Math.sqrt(4 * b + 1) - 1) / 2);
        return odd > even ? 2 * even + 1 : 2 * odd;
    }





}
