package LeetCode;

import com.sun.source.doctree.SeeTree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/11 13:04
 * @desc:力扣第139题：单词拆分（动态规划之背包思想）
 */
public class Problem139 {
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordSet =new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1;i <= n;i++){
            for (int j = 0;j < i;j++){
                if (dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
                return dp[n];
    }
}
