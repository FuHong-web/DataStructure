package LeetCode_Revice4.duoweidongtaiguihua;

import java.nio.charset.StandardCharsets;

/*最长公共子序列*/
public class p1143 {
    public int longestCommonSubsequence(String text1, String text2){
        int m = text1.length();
        int n= text2.length();
        // dp[i][j]：text1前i个字符，text2前j个字符，的最长公共子序列长度
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            for (int j = 0; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
