package test;

public class LifeGame {
    public void gameOfLife(int[][] board) {
        //活细胞周围两个或者三个活细胞时存活，死细胞周围三个活细胞时存活，其余情况都死亡
        //遍历每个格子 看他们如何影响周围八个格子
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] % 10 == 1) {
                    //周围八个加10
                    change(board, i, j);
                }
            }
        }
        //遍历每个格子 根据影响获得新的状态
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j] / 10 == 2 || board[i][j] / 10 == 3) && board[i][j] % 10 == 1) {
                    board[i][j] = 1;
                } else if (board[i][j] / 10 == 3 && board[i][j] % 10 == 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public void change(int[][] board, int i, int j) {
        if (i > 0) {
            board[i - 1][j] += 10;
            if (j > 0) {
                board[i - 1][j - 1] += 10;
            }
        }
        if (i < board.length - 1) {
            board[i + 1][j] += 10;
            if (j < board[0].length - 1) {
                board[i + 1][j + 1] += 10;
            }
        }
        if (j > 0) {
            board[i][j - 1] += 10;
            if (i < board.length - 1) {
                board[i + 1][j - 1] += 10;
            }
        }
        if (j < board[0].length - 1) {
            board[i][j + 1] += 10;
            if (i > 0) {
                board[i - 1][j + 1] += 10;
            }
        }
    }
}
