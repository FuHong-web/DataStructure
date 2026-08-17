package LeetCode_Revice4.juzhen;
/*搜索二维矩阵ii*/
public class p240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while (row < matrix.length && col >=0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }
}
