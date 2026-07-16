package LeetCode_Revice1.juzhen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/9 21:00
 * @desc:矩阵
 */
public class P54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;

        int left = 0;
        int right = matrix[0].length;  // 右边界（不包含）
        int top = 0;
        int bottom = matrix.length;    // 下边界（不包含）

        while (left < right && top < bottom) {

            // 1. 左 → 右（顶行）✅
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top >= bottom) break;

            // 2. 上 → 下（右列）✅
            for (int j = top; j < bottom; j++) {
                res.add(matrix[j][right - 1]);
            }
            right--;
            if (left >= right) break;

            // 3. 右 → 左（底行）❌ 你原来写反了！
            // 正确：从 right-1 向左走到 left
            for (int k = right - 1; k >= left; k--) {
                res.add(matrix[bottom - 1][k]);
            }
            bottom--;
            if (top >= bottom) break;

            // 4. 下 → 上（左列）❌ 你原来写反了！
            // 正确：从 bottom-1 向上走到 top
            for (int m = bottom - 1; m >= top; m--) {
                res.add(matrix[m][left]);
            }
            left++;
        }
        return res;
    }
}
