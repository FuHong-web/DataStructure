package Revice2.huisu;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/1 8:30
 * @desc:单词搜索
 */
public class p79 {

    public boolean exist(char[][] board, String word) {
        // m行数，n列数
        int m = board.length;
        int n = board[0].length;
        // 标记格子是否在当前路径被使用
        boolean[][] visited = new boolean[m][n];

        // 遍历棋盘每一个起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从(i,j)开始搜索，当前匹配第0个字符
                boolean find = search(board, word, i, j, 0, visited);
                if (find) {
                    // 找到完整单词直接返回true
                    return true;
                }
            }
        }
        // 全部起点都试过，没找到
        return false;
    }

    /**
     * 深度优先回溯搜索
     * @param board 字母棋盘
     * @param word 目标单词
     * @param x 当前所在行
     * @param y 当前所在列
     * @param cur 当前要匹配单词的第cur位
     * @param visited 访问标记数组
     * @return 是否匹配成功
     */
    public boolean search(char[][] board, String word, int x, int y, int cur, boolean[][] visited) {
        // 终止条件：cur等于单词长度，说明全部字符匹配完成
        if (cur == word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;
        // 边界判断：坐标超出棋盘范围，直接失败
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        // 当前格子字符不匹配 或者 已经走过这条路，失败
        if (board[x][y] != word.charAt(cur) || visited[x][y]) {
            return false;
        }

        // 标记当前格子已占用，本条路径不能重复走
        visited[x][y] = true;

        // 上下左右四个方向递归找下一个字符
        boolean up = search(board, word, x - 1, y, cur + 1, visited);
        boolean down = search(board, word, x + 1, y, cur + 1, visited);
        boolean left = search(board, word, x, y - 1, cur + 1, visited);
        boolean right = search(board, word, x, y + 1, cur + 1, visited);

        // 回溯：取消标记，给其他分支复用该格子
        visited[x][y] = false;

        // 任意一个方向走通就返回true
        return up || down || left || right;
    }

}
