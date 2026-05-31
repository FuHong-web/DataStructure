package LeetCode_Revice.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/14 23:32
 * @desc:括号生成
 */
public class p22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        pipei(n, 0, 0, temp, res);
        return res;
    }

    private void pipei(int n, int left, int right, StringBuilder temp, List<String> res) {
        // 出口：左右括号都够 n 个，就是合法结果
        if (left == n && right == n) {
            res.add(temp.toString());
            return;
        }

        // 1. 左括号没满 → 可以加 (
        if (left < n) {
            temp.append("(");
            pipei(n, left + 1, right, temp, res);
            temp.deleteCharAt(temp.length() - 1); // 回溯
        }

        // 2. 右括号数量 < 左括号 → 才能加 )
        if (left > right) {
            temp.append(")");
            pipei(n, left, right + 1, temp, res);
            temp.deleteCharAt(temp.length() - 1); // 回溯
        }
    }

}
