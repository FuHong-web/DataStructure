package LeetCode_Revice3.juzhen;
/*搜索矩阵2*/
public class p240 {
    public boolean searchMatrix(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col >= 0){
            int x= matrix[row][col];
            if (x == target) {
                return true;
            }else if (x < target){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }
}
