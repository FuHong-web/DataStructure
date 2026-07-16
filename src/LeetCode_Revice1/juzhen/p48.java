package LeetCode_Revice1.juzhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/11 22:38
 * @desc:旋转图像
 */
public class p48 {
    public class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int left = 0;
            int right = n - 1;

            // 逐层处理外圈，向内收缩
            while (left < right) {
                // 每层要交换的元素个数：right - left
                for (int i = 0; i < right - left; i++) {
                    int top = left;
                    int bottom = right;

                    // 暂存左上角元素
                    int topLeft = matrix[top][left + i];

                    // 左下角 → 左上角
                    matrix[top][left + i] = matrix[bottom - i][left];
                    // 右下角 → 左下角
                    matrix[bottom - i][left] = matrix[bottom][right - i];
                    // 右上角 → 右下角
                    matrix[bottom][right - i] = matrix[top + i][right];
                    // 左上角（暂存值） → 右上角
                    matrix[top + i][right] = topLeft;
                }

                // 向内收缩一层
                left++;
                right--;
            }
        }
    }
}
