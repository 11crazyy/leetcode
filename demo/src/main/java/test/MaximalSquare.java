package test;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        //dp[i][j]表示以i-1，j-1为右下角的最大正方形的边长
        if (matrix.length == 0){
            return 0;
        }
        int[][] dp =new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                
            }
        }
    }
}
