package LeetCode_Revice3.huadongchuangkou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*找到字符串中所有字母异位词*/
public class p438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res= new ArrayList<>();
        Map<Character,Integer> needMath = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            needMath.put(c,needMath.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right =0;
        int match =0;
        while (right < s.length()){
            char c = s.charAt(right++);
            if(needMath.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(needMath.get(c))){
                    match++;
                }
            }
            /*结果录入*/
            while (right-left==p.length()){
                if (match == needMath.size()){
                    res.add(left);
                }


                /*窗口收缩*/
                char l = s.charAt(left++);
                if(needMath.containsKey(l)){
                    if (window.get(l).equals(needMath.get(l))){
                        match--;
                    }
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return res;
    }
}
