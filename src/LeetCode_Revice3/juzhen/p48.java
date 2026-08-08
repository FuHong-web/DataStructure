package LeetCode_Revice3.juzhen;
/*旋转图像*/
public class p48 {
    public void rotate(int[][] matrix) {
        int n =matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {//i+1是因为只要交换上三角而已
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n-1;
            while (l <= r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
        }
    }
}
