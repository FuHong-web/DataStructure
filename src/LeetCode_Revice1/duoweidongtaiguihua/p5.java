package LeetCode_Revice1.duoweidongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/4 23:38
 * @desc:最长回文字符串
 */
public class p5 {
    public String longestPalindrome(String s) {
        // 边界：空串直接返回
        if (s == null || s.length() < 1) return "";

        int n = s.length();
        int start = 0;   // 最长回文 起始位置
        int maxLen = 1;  // 最长回文 长度（最少1个字符）

        // ==================== DP 核心 ====================
        // dp[i][j] = 字符串 s 从 i 到 j 是否是回文
        boolean[][] dp = new boolean[n][n];

        // 1. 初始化：单个字符一定是回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 2. 填 DP 表：从长度 2 开始填
        for (int j = 1; j < n; j++) {  // 右指针 j 往后走
            for (int i = 0; i < j; i++) { // 左指针 i 必须 < j

                // 情况1：两个字符相等 → 是回文
                if (s.charAt(i) == s.charAt(j) && j - i == 1) {
                    dp[i][j] = true;
                }
                // 情况2：首尾相等 + 中间是回文 → 是回文
                else if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }

                // 如果当前是回文，并且更长 → 更新答案
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        // 截取结果返回
        return s.substring(start, start + maxLen);
    }
}
