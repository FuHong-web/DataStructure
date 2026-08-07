package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/27 23:26
 * @desc:找出字段串的所有异位字符（滑动窗口）
 */
public class Problem438 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            Map<Character,Integer> needMatch = new HashMap<>();
            Map<Character,Integer> window = new HashMap<>();
            for(char c : s.toCharArray()){
                needMatch.put(c,needMatch.getOrDefault(c,0)+1);
            }
            int left=0;
            int right = 0;
            int match = 0;
            while (right <s.length()){
                char c = s.charAt(right++);
                if(needMatch.containsKey(c)){
                    window.put(c,window.getOrDefault(c,0)+1);
                    if (window.get(c).equals(needMatch.get(c))){
                        match++;
                    }
                }
            }
            while (right-left==window.size()){
                if (match == needMatch.size()){
                    res.add(left);
                }
                char l = s.charAt(left++);
                if(needMatch.get(l).equals(window.get(l))){
                    match--;
                }
                window.put(l,window.get(l)-1);
            }
return res;
        }
}
