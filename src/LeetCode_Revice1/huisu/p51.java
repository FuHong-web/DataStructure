package LeetCode_Revice1.huisu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/9 21:40
 * @desc:n皇后
 * 每一行只做 4 件事：
 * 尝试放一列
 * 检查会不会打架
 * 不打架就放，去下一行
 * 回来拿走，试下一列（回溯）
 *
 * 一行一行放，天然避免了行冲突
 * 3 个 Set 让判断速度极快
 * 回溯干净：放 → 递归 → 拿走
 * 代码简洁标准，面试满分！
 */
public class p51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] bord = new char[n][n];
        for (int i =0;i <n;i++) {
            for (int j = 0;j<n;j++) {
                bord[i][j] = '.';
            }
        }
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> addSet = new HashSet<>();
        Set<Integer> subSet = new HashSet<>();
        dfs(res,colSet,addSet,subSet,n,0,bord);
        return res;
    }

    private void dfs(List<List<String>> res,
                     Set<Integer> colSet,
                     Set<Integer> addSet,
                     Set<Integer> subSet,
                     int n,
                     int row,
                     char[][] bord) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : bord) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }
        for (int col = 0;col < n;col++) {
            if (colSet.contains(col) || addSet.contains(row + col) || subSet.contains(row - col)) {
                continue;
            }
            colSet.add(col);
            addSet.add(row+col);
            subSet.add(row-col);
            bord[row][col] = 'Q';
            dfs(res,colSet,addSet,subSet,n,row+1,bord);
            colSet.remove(col);
            addSet.remove(row+col);
            subSet.remove(row-col);
        }
    }
}
