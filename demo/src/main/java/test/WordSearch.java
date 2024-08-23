package test;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] words, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[index]) {
            return false;
        }
        if (index == words.length - 1) {
            return true;
        }
        board[i][j] = '/';
        boolean res = dfs(board, i, j - 1, words, index + 1) || dfs(board, i - 1, j, words, index + 1) || dfs(board,i + 1, j, words, index + 1) || dfs(board,i, j + 1, words, index + 1);
        board[i][j] = words[index];
        return res;
    }
}
