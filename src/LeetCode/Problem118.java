package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/21 23:19
 * @desc:力扣第118题：杨辉三角(数组+动态规划)
 */
public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows >= 1) {
            res.add(Arrays.asList(1));  // 第1行
        }

        if (numRows >= 2) {
            res.add(Arrays.asList(1, 1));  // 第2行：修正为[1,1]
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>(i + 1);
            // 初始化所有元素为1
            for (int j = 0; j <= i; j++) {  // 修正：j++，不是i++
                temp.add(1);
            }
            // 计算中间元素（从索引1到i-1）
            for (int k = 1; k < i; k++) {  // 修正：从k=1开始
                temp.set(k, res.get(i - 1).get(k) + res.get(i - 1).get(k - 1));
            }
            res.add(temp);
        }
        return res;
    }
}
