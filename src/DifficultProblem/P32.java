package DifficultProblem;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/14 17:00
 * @desc:最长有效括号
 */
public class P32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] len = new int[n];
        int maxLen = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                // 情况1：紧邻前一位是 ( 形如 ()
                if (s.charAt(i - 1) == '(') {
                    len[i] = (i - 2 >= 0) ? len[i - 2] + 2 : 2;
                } else {
                    // 情况2：前一位也是 ) 形如 ((...))
                    int m = i - len[i - 1] - 1;
                    if (m >= 0 && s.charAt(m) == '(') {
                        len[i] = len[i - 1] + 2;
                        // 拼接m左侧连续合法括号
                        if (m - 1 >= 0) {
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
