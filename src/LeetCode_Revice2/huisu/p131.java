package LeetCode_Revice2.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/1 8:59
 * @desc:分割回文串
 */
public class p131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(res,temp,0,s);
        return res;

    }
    private void dfs(List<List<String>> res,List<String> temp,int start,String s){
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int end = start;end<s.length();end++){
            if (isHw(s,start,end)) {
                String sub = s.substring(start,end+1);
                temp.add(sub);
                dfs(res,temp,end+1,s);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isHw(String s,int left,int right) {
        while (left<right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
