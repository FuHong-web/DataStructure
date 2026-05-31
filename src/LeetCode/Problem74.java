package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/25 14:31
 * @desc:力扣第74题：74. 搜索二维矩阵
 */
public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;                // 从0开始
        int right = m * n - 1;       // 最后一个下标

        while (left <= right) {      // 正确循环
            int mid = left + (right - left)/2;
            int x = matrix[mid / n][mid % n];

            if (x == target) {
                return true;        // 找到返回true
            }

            if (x < target) {
                left = mid + 1;     // 右移
            } else {
                right = mid - 1;    // 左移
            }
        }

        return false;               // 找不到才返回false
    }
}
