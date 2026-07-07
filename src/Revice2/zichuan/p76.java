package Revice2.zichuan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/5 16:07
 * @desc:最小覆盖子串
 */
public class p76 {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch,need.getOrDefault(ch,0)+1);
        }

        int left = 0;
        int right = 0;
        int match = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        while (right<s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r,window.getOrDefault(r,0)+1);
                if (window.get(r).equals(need.get(r))){
                    match++;
                }
            }

            while (match == need.size()) {
                int curLen = right - left;
                if (curLen < minLen) {
                    minLen = curLen;
                    start = left;
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)){
                    if (window.get(l).equals(need.get(l))) {
                        match--;
                    }
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start+minLen);
    }
}
