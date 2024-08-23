package test;

public class DifferentPathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[len][column];
        if (obstacleGrid[0][0]==1||obstacleGrid[len -1][column-1]==1){
            return 0;
        }
        for (int i = 0; i < len && obstacleGrid[i][0]==0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < column && obstacleGrid[0][i]==0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[len-1][column-1];
    }
}
