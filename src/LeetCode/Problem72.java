package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/20 22:42
 * @desc:72. 编辑距离(动态规划)
 */
public class Problem72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j] 表示 word1前i个字符 转成 word2前j个字符 的最小编辑距离
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始化第一行：word1为空，只能不断插入
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        // 初始化第一列：word2为空，只能不断删除
        // 错误1：原代码 i < len1，少遍历了一行，应该是 i <= len1
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        // 填充dp表
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 字符相等：不需要操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 错误2：Java 的 Math.min 只支持两个参数，且三个操作都要 +1
                    // 替换 dp[i-1][j-1]、删除 dp[i-1][j]、插入 dp[i][j-1]
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }

        // 错误3：原代码 return 语法不完整，应该返回右下角最终结果
        return dp[len1][len2];
    }
}
