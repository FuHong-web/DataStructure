package LeetCode_Revice5.dongtaiguihua;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
*
* 1. 外层 i：枚举**字符串前缀长度**，从 1 到 n
2. 内层 j：在 0~i 之间找分割点，把前 i 个字符切成两段：
   - 第一段：前 j 个字符（由`dp[j]`判断能不能拆分）
   - 第二段：`s.substring(j,i)`，看是不是字典单词
3. 只要找到任意一个 j 满足条件，dp [i] 直接设 true，break 内层循环（不用继续找其他分割点）*/
/*单词拆分*/
public class p139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
