package LeetCode_Revice.erfenchazhao;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/29 22:13
 * @desc:搜索二为矩阵（）
 * 把二维数组当一维有序数组，直接二分查找，用 mid/n 和 mid% n 转回二维坐标！
 */
public class p74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = m * n;
        int right = m * n;
        while (left < right) {
            int mid = (left + right) / 2;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return false;
            }
            if (x < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return false;
    }

}
