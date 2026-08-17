package LeetCode_Revice4.juzhen;
/*旋转矩阵*/
public class P48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 1.矩阵转置
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2.每行左右翻转
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
