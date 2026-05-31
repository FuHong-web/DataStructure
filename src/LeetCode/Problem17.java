package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/12 21:49
 * @desc:力扣第17题：电话号码的字母组合(动态规划)
 */
public class Problem17 {
    public List<String> letterCombinations(String digits) {
        List<String> col=new ArrayList<>();
        if (digits.length()==0){
            return col;
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
        traback(col,map,digits,0,new StringBuilder());
        return col;
    }
    public void traback(List<String> col,Map<Character,String> map,String digits,int index,StringBuilder builder){
        if (index==digits.length()){
            col.add(builder.toString());
        }else {
            char zifu=digits.charAt(index);
            String letter=map.get(zifu);
            int length=letter.length();
            for (int i=0;i<length;i++){
                builder.append(letter.charAt(i));
                traback(col,map,digits,index+1,builder);
                builder.deleteCharAt(index);
            }
        }
    }
}
