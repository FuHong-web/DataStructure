package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/23 22:39
 * @desc:最长有效括号（动态规划）
 */
public class Problem32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] len = new int[n];
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                // 情况1：前一个是 (，直接配对
                if (s.charAt(i-1) == '(') {
                    len[i] = (i-2 >= 0) ? len[i-2] + 2 : 2;
                }
                // 情况2：前一个是 )，往前跳去找匹配的 (
                else {
                    int m = i - len[i-1] - 1;
                    if (m >= 0 && s.charAt(m) == '(') {
                        len[i] = len[i-1] + 2;
                        // 加上 m 前面的有效长度
                        if (m - 1 >= 0) {
                            len[i] += len[m-1];
                        }
                    }
                }
                maxLen = Math.max(maxLen, len[i]);
            }
        }
        return maxLen;
    }
}
