package LeetCode_Revice2.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/21 10:57
 * @desc:最长有效括号
 */
public class p32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] len = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    len[i] = (i - 2 >= 0) ? len[i - 2] : 2;
            } else {
                int m = i - len[i - 1] - 1;
                if (m > 0 && s.charAt(m) == '(') {
                    len[i] = len[i - 1] + 2;
                    if (m - 1 > 0) {
                        len[i] += len[m - 1];
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }
    }
    return maxLen;
}
}
