package LeetCode_Revice1.huadongchuangkou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/1 22:31
 * @desc:找出字段串的所有异位字符
 */
public class p438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // 1. 构建目标字符频率表
        Map<Character, Integer> needMatch = new HashMap<>();
        for (char c : p.toCharArray()) {
            needMatch.put(c, needMatch.getOrDefault(c, 0) + 1);
        }

        // 2. 滑动窗口变量
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int match = 0; // 已匹配的字符种类数

        // 3. 滑动窗口主循环
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 窗口右移：更新窗口内的字符计数
            if (needMatch.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needMatch.get(c))) {
                    match++;
                }
            }

            // 窗口大小等于 p 长度时，开始收缩左边界
            while (right - left == p.length()) {
                // 所有字符都匹配上了，说明是异位词
                if (match == needMatch.size()) {
                    result.add(left);
                }

                // 窗口左移：移除左边字符
                char l = s.charAt(left);
                left++;

                // 如果是目标字符，更新窗口计数和匹配数
                if (needMatch.containsKey(l)) {
                    if (window.get(l).equals(needMatch.get(l))) {
                        match--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }

        return result;
    }
}
