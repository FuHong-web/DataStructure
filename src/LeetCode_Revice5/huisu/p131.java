package LeetCode_Revice5.huisu;

import java.util.ArrayList;
import java.util.List;
/*1. or i = index；i <s.length ()：尝试从 index 切到 i，区间 `[index,i]`
2. 如果这段是回文：加入 temp，下一轮起点是 `i+1`（i 位置已经被切在这一段里了，下一次从 i 后面开始）*/
/*分割回文串*/
public class p131 {
    public List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        help(s,res,temp,0);
        return res;
    }
    private void help(String s,List<List<String>> res,List<String> temp,int index){
        if(index == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index;i < s.length();i++){
            if(huiwen(s,index,i)){
                temp.add(s.substring(index,i+1));
                help(s,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean huiwen(String s,int left,int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
