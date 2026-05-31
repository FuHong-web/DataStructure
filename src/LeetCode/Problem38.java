package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/5 22:20
 * @desc:旋转图像（二维矩阵）
 */
public class Problem38 {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; ++i) {
                int top = left;
                int bottom = right;
                int topleft = matrix[top][left + i];

                // 四个位置循环赋值
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = topleft;
            }
            ++left;
            --right;
        }
    }
}
