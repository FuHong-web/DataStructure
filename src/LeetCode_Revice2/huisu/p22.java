package LeetCode_Revice2.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/30 22:53
 * @desc:括号生成
 */
public class p22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        help(res,temp,0,0,n);
        return res;

    }
    private void help(List<String> res,StringBuilder temp,int left,int right,int n) {
        if (left ==n && right==n) {
            res.add(temp.toString());
            return;
        }
        if (left<n) {
            temp.append('(');
            help(res,temp,left+1,right,n);
            temp.deleteCharAt(temp.length()-1);
        }
        if (right<left) {
            temp.append(')');
            help(res,temp,left,right+1,n);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
