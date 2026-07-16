package LeetCode_Revice1.duoweidongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/4 22:53
 * @desc:不同路径
 */
public class p62 {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }
        return result[m-1][n-1];
    }
}
