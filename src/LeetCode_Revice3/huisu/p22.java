package LeetCode_Revice3.huisu;

import java.util.ArrayList;
import java.util.List;

/*括号生成*/
public class p22 {
    public List<String> generateParenthesis(int n) {
        List<String> res =new ArrayList<>();
        StringBuilder temp =new StringBuilder();
        help(n,0,0,res,temp);
        return res;
    }
    private void help(int n,int left,int right,List<String> res,StringBuilder temp) {
        if (left ==n && right==n) {
            res.add(temp.toString());
            return;
        }
        if (left<n) {
            temp.append("(");
            help(n,left+1,right,res,temp);
            temp.deleteCharAt(temp.length()-1);
        }

        if (right<left) {
            temp.append(")");
            help(n,left,right+1,res,temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }

}
