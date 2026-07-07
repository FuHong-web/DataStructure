package LeetCode_Revice.zichuan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/8 22:40
 * @desc:最小覆盖子串(滑动窗口)
 * 滑动窗口：右扩找可行解，左缩找最优解！
 * 右指针一直往右走，把字符加进窗口
 * 窗口包含了 t 所有字符时
 * 左指针开始缩，尽量缩到最短
 * 记录最短的那一段
 */
public class p76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 填充t需求
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0;
        int match = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    match++;
                }
            }

            // 全部匹配，收缩
            while (match == need.size()) {
                int curLen = right - left;
                if (curLen < minLen) {
                    minLen = curLen;
                    minStart = left;
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        match--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
