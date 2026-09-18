package LeetCode_Revice5.huisu;

import java.util.ArrayList;
import java.util.List;

/*括号生成*/
public class p22 {
    public List<String> generateParenthesis(int n){
        List<String> res= new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        help(n,res,temp,0,0);
        return res;
    }

    private void help(int n,List<String> res,StringBuffer temp,int left,int right){
        if(left == n && right == n){
            res.add(temp.toString());
            return;
        }
        while (left < n){
            temp.append('(');
            help(n,res,temp,left+1,right);
            temp.deleteCharAt(temp.length()-1);
        }
        while (right <left) {
            temp.append(')');
            help(n,res,temp,left,right+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
