package LeetCode_Revice1.huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/14 22:04
 * @desc:电话号码的字母组合
 */
public class p17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0){
            return res;
        }
        Map<Character,String> map=new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(res,map,0,digits,new StringBuilder());

        return res;
    }
    private void dfs(List<String> res, Map<Character,String> map,int index, String s, StringBuilder builder){
        if (index == s.length()) {
            res.add(builder.toString());
            return;
        }else {
            char c = s.charAt(index);
            String letter = map.get(c);
            int len = letter.length();
            for (int i = 0; i < len; i++) {
                builder.append(letter.charAt(i));
                dfs(res,map,index + 1,s,builder);
                builder.deleteCharAt(index);
            }
        }
    }
}
