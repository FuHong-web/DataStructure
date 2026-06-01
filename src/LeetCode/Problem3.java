package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2025/12/29 20:01
 * @desc:力扣第3题：无重复的最长子字符串
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            // 遇到重复，收缩左边界
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // 加入当前字符
            set.add(s.charAt(right));
            // 直接计算窗口长度，无需单独维护length变量
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
