package LeetCode_Revice1.dongtaiguihua;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/20 23:37
 * @desc:
 */
public class p39 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // 修正拼写
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // 你写对了！

        // 外层 i 从 1 开始到 n（你之前从0开始也能跑，但不标准）
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
