package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/30 23:27
 *
 * visit[row][col] = true;  // 标记当前格子已被占用
 *
 * // 向四个方向探索
 * res |= dfs(下);  // 在 dfs(下) 中，当前格子被标记为 true
 * res |= dfs(右);  // 所以不会走回头路
 * res |= dfs(上);
 * res |= dfs(左);
 *
 * visit[row][col] = false;  // 探索完成，释放
 * @desc:力扣第79题：单词搜索（回溯）
 */
public class Problem79 {
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
