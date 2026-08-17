package LeetCode_Revice4.juzhen;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/*螺旋矩阵*/
public class p54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix == null || matrix.length == 0) return res;

        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        while (top <= bottom && left <= right){

            for(int i = left;i <= right;i++){
                res.add(matrix[top][i]);
            }
            top++;

            if(top <= bottom) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;
            }

            if(left <= right){
            for(int i = right;i >= 0;i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            }
            if(top <= bottom){
            for(int i = bottom;i >= 0;i--){
                res.add(matrix[i][left]);
            }
            left++;
            }
        }
        return res;
    }
}
