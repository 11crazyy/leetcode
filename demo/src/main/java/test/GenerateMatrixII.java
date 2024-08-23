package test;

public class GenerateMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int tar = n * n,num = 1;
        int left = 0,right = n - 1,up = 0,down = n - 1;
        while (num <= tar){
            for (int i = left; i <= right; i++) {
                result[up][i] = num++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                result[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[down][i] = num++;
            }
            down--;
            for (int i = down; i >=up ; i++) {
                result[i][left] = num++;
            }
            left++;
        }
        return result;
    }
}
