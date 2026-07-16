package LeetCode_Revice1.duoweidongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/7 19:34
 * @desc:
 */
public class p72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // dp[i][j] 表示：word1前i个字符 → word2前j个字符 最少几步
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化第一行：word1为空，变成前j个字符，需要插j次
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j-1] + 1;
        }

        // 初始化第一列：word1前i个字符，变成空，需要删i次
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }

        // 开始填表
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                // 如果当前字母一样！不用改！直接继承左上角
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // 字母不一样：选 替换/删除/插入 里最小的 + 1步
                else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i-1][j-1], dp[i-1][j]),
                            dp[i][j-1]
                    ) + 1;  // 你这里漏了 +1！
                }
            }
        }

        return dp[len1][len2];
    }
}
