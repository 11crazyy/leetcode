package test;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //找右上角元素
        int j = matrix[0].length - 1;
        int i = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }
        }
        return false;
    }
}
