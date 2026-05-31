package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/5 22:00
 * @desc:搜索二维矩阵ii
 */
public class Problem240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int startCol = matrix[0].length - 1;

        while (startCol >= 0 && startRow < matrix.length) {
            if (matrix[startRow][startCol] == target) {
                return true;
            } else if (matrix[startRow][startCol] < target) {
                startRow++;   // 比目标小，往下走
            } else if (matrix[startRow][startCol] > target) {
                startCol--;   // 比目标大，往左走
            }
        }
        return false;  // 这里必须是 false
    }
}
