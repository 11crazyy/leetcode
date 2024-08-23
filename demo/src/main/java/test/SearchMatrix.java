package test;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        for (int i = 1; i < matrix.length; i++) {
            if (target >= matrix[i - 1][0] && target < matrix[i][0]) {
                row = i - 1;
                break;
            }
        }
        int column = matrix[0].length;
        for (int i = 0; i < column; i++) {
            if (matrix[row][i] == target) return true;
        }
        return false;
    }
}
