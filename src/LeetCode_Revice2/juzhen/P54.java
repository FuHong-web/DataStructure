package LeetCode_Revice2.juzhen;

import java.util.ArrayList;
import java.util.List;

/*旋转矩阵*/
public class P54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        List<Integer> res = new ArrayList<>();

        while (left < right && top < bottom) {
            // 1. 左 → 右（顶行）
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top >= bottom) break;

            // 2. 上 → 下（右列）
            for (int j = top; j < bottom; j++) {
                res.add(matrix[j][right - 1]);
            }
            right--;
            if (left >= right) break;

            // 3. 右 → 左（底行）【你这里错了两处】
            for (int k = right - 1; k >= left; k--) {  // 修复：k 起点 & 条件
                res.add(matrix[bottom - 1][k]);         // 修复：行下标
            }
            bottom--;
            if (bottom <= top) break;

            // 4. 下 → 上（左列）【你这里错了一处】
            for (int m = bottom - 1; m >= top; m--) {  // 修复：m 起点 & 条件
                res.add(matrix[m][left]);
            }
            left++;
        }
        return res;
    }
}
