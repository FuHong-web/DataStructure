package LeetCode_Revice3.huisu;

import java.util.ArrayList;
import java.util.List;

/*分割回文串*/
public class p131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        help(s,0,res,temp);
        return res;
    }
    private void help(String s,int index,List<List<String>> res,List<String> temp) {
        if (index== s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index;i<s.length();i++){
            if (huiWen(s,index,i)){
                temp.add(s.substring(index,i+1));
                help(s,i+1,res,temp);
                temp.remove(temp.size()-1);
            }
        }

    }
    private boolean huiWen(String s,int l,int r) {
        if (s.length() == 0) return true;
        while (l<r) {
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
