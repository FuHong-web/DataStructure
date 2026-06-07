package LeetCode_Revice.duoweidongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/5 23:54
 * @desc:最长公共子序列
 */
public class p1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 定义 dp 数组，大小为 (m+1) * (n+1)，避免边界判断
        int[][] dp = new int[m + 1][n + 1];
        // 初始化：dp[0][*] 和 dp[*][0] 都为 0（默认值就是 0，可省略写）
        // for (int i = 0; i <= m; i++) dp[i][0] = 0;
        // for (int j = 0; j <= n; j++) dp[0][j] = 0;
        // 双重循环遍历两个字符串
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 两个字符相等，取左上值 +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 两个字符不相等，取上侧或左侧的较大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 右下角就是答案
        return dp[m][n];
    }
}
