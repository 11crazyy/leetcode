package test;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int begin = 0;
        int left = 0,right = matrix[0].length - 1,up = 0,down = matrix.length - 1;
        while (left <=right && up <= down){
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);//右移
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);//下移
            }
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            down--;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return list;
    }
}
