package LeetCode_Revice.zichuan;

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
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 统计 t 中字符需要的数量
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int[] window = new int[128];
        int left = 0, right = 0;
        int needCount = t.length(); // 需要匹配的总字符数
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            // 当前字符在需求里
            if (need[c] > 0) {
                window[c]++;
                // 只有窗口里的数量 <= 需要的数量，才算有效匹配
                if (window[c] <= need[c]) {
                    needCount--;
                }
            }

            // 窗口满足条件，开始收缩左边
            while (needCount == 0) {
                // 更新最小窗口
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                left++;

                if (need[d] > 0) {
                    if (window[d] == need[d]) {
                        needCount++;
                    }
                    window[d]--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
