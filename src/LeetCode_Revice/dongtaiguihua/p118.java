package LeetCode_Revice.dongtaiguihua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/16 23:50
 * @desc:杨辉三角
 */
public class p118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        // 第一行
        if (numRows >= 1) {
            res.add(Arrays.asList(1));
        }
        // 第二行
        if (numRows >= 2) {
            res.add(Arrays.asList(1, 1));
        }

        // 从第三行开始 i=2（索引）
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();

            // 先填满 1（必须 j<=i，保证长度）
            for (int j = 0; j <= i; j++) {
                temp.add(1);
            }
            // 计算中间的值：左上 + 正上
            for (int k = 1; k < i; k++) {
                temp.set(k, res.get(i-1).get(k-1) + res.get(i-1).get(k));
            }

            // 把当前行加入结果！！你之前漏了这句
            res.add(temp);
        }

        return res;
    }
}
