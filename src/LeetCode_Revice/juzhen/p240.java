package LeetCode_Revice.juzhen;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/14 16:55
 * @desc:搜索二维矩阵ii
 */
public class p240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int startCol = matrix[0].length -1;
        //matrix[startRow][startCol]为右上角的元素
        while (startCol >= 0 && startRow < matrix.length) {
            if (matrix[startRow][startCol] == target) {
                return true;
            }else if (matrix[startRow][startCol] < target) {
                startRow ++;
            }else if (matrix[startRow][startCol] > target) {
                startCol--;
            }

        }
        return false;
    }
}
