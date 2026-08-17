package LeetCode_Revice4.huadongchuangkou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*找到字符串中所有字母异位词*/
public class p438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(char ss :p.toCharArray()){
            need.put(ss,need.getOrDefault(ss,0)+1);
        }

        int left = 0;
        int right = 0;
        int match = 0;
        while (right < s.length()){
            char r = s.charAt(right++);
            if(need.containsKey(r)){
                window.put(r,window.getOrDefault(r,0)+1);
                if(window.get(r).equals(need.get(r))){
                    match++;
                }
            }

            // 固定窗口：窗口长度等于p的长度
            while (right - left == p.length()) {
                if(match == need.size()){
                    res.add(left);
                }

                char l = s.charAt(left++);
                // 必须先判断是否是目标字符，防止空指针
                if(need.containsKey(l)){
                    if(window.get(l).equals(need.get(l))){
                        match--;
                    }
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return res;
    }
}
