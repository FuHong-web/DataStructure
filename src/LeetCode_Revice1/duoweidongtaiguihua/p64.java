package LeetCode_Revice1.duoweidongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/4 23:19
 * @desc:最短路径
 */
public class p64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            res[i][0] = res[i-1] [0]+grid[i][0];
        }
        for (int i = 0; i < col; i++) {
            res[0][i] = res[0][i-1] + res[0][i];
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = Math.min(res[i-1][j],res[i][j-1]) + grid[i][j];
            }
        }
        return res[row-1][col - 1];
    }
}
