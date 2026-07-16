package LeetCode_Revice2.huadongchuangkou;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/6 22:46
 * @desc:无重复字符的子串
 */
public class p3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // 当前字符在窗口内重复，不断左移左边界
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            // 更新最长长度
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
