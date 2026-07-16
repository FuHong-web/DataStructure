package LeetCode_Revice1.huisu;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/15 21:56
 * @desc:单词搜索
 */
public class p79 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visit = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visit) {
        if (index == word.length()) {
            return true;
        }
        int rows = board.length;
        int cols = board[0].length;
        if (row >= rows || row < 0 || col >= cols || col < 0 ||
                board[row][col] != word.charAt(index) || visit[row][col]) {
            return false;
        }
        visit[row][col] = true;
        boolean res = false;
        res |= dfs(board, word, row + 1, col, index + 1, visit);
        res |= dfs(board, word, row, col + 1, index + 1, visit);
        res |= dfs(board, word, row - 1, col, index + 1, visit);
        res |= dfs(board, word, row, col - 1, index + 1, visit);
        visit[row][col] = false;
        return res;
    }

}
