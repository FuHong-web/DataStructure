package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/23 22:08
 * @desc:n皇后（回溯）
 */
public class Problem51 {
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
                     char[][] board) {
        if(row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }
        for (int col = 0;col < n;col++){
            if (colSet.contains(col) || addSet.contains(row + col) || subSet.contains(row -col)) {
                continue;
            }
            colSet.add(col);
            addSet.add(row+col);
            subSet.add(row-col);
            board[row][col] = 'Q';
            dfs(res,colSet,addSet,subSet,n,row+1,board);
            colSet.remove(col);
            addSet.remove(row+col);
            subSet.remove(row-col);
            board[row][col]='.';
        }

    }
}
