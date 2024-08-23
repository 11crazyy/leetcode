package test;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        //用第一行和第一列来存矩阵是否有0 记录第一行和第一列里面的0
        boolean zeroRow = false;
        boolean zeroColumn = false;
        //找第一列和第一行是否有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) zeroRow = true;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) zeroColumn = true;
        }
        //用第一列和第一行存整个矩阵中的0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 0; zeroRow && i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; zeroColumn && i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }
    }
}
