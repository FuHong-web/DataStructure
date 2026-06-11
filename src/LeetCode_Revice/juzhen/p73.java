package LeetCode_Revice.juzhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/8 22:52
 * @desc:矩阵置零
 */
public class p73 {
    public void setZeroes(int[][] matrix) {
        int m  = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        //先标记
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        //再置0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}