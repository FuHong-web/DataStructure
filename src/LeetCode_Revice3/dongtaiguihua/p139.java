package LeetCode_Revice3.dongtaiguihua;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*单词拆分*/
public class p139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1;i<= n;i++){
            for (int j = 0;j <i;j++) {
                if (dp[j] == true && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
