package LeetCode_Revice3.huisu;

import java.util.ArrayList;
import java.util.List;

/*分割回文串*/
public class p131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        help(s,res,temp,0);
        return res;
    }
    private void help(String s,List<List<String>> res,List<String> temp ,int index){
        if(index==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i= index;i < s.length();i++){
            if(huiwen(s,i,index)){
                temp.add(s.substring(index,i+1));
                help(s,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    private boolean huiwen(String s,int left,int right){
        if(s.length()==0){
            return true;
        }
        while (left < right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
