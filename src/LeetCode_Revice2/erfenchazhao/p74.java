package LeetCode_Revice2.erfenchazhao;

import javax.xml.stream.XMLInputFactory;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/8 22:37
 * @desc:
 */
public class p74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <=right) {
            int mid = left + (right - left) / 2;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }else if (x < target) {
                left = mid + 1;
            }else {
                right  = mid - 1;
            }
        }
        return false;
    }
}
