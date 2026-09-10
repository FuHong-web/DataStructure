package LeetCode_Revice4.dongtaiguihua;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*单词拆分*/
public class p139 {
    public boolean wordBreak(String s, List<String> wordDict){
        // 把list转HashSet，contains查询O(1)，提升查询速度
        Set<String> wordSet =new HashSet<>(wordDict);
        int n = s.length();
        // dp[i]：字符串s的【前i个字符】是否可以被成功拆分
        boolean[] dp = new boolean[n+1];
        // base case：前0个字符（空字符串），默认可以拆分
        dp[0] = true;

        // i：代表前i个字符，范围1~n
        for (int i = 1;i <= n;i++){
            // j：分割点，把前i个字符切分成两部分：前j个字符 + 子串 s[j,i)
            for (int j = 0;j < i;j++){
                // 条件：①前j个字符可以拆分 dp[j]=true
                //      ② j到i这段子串，正好存在于单词集合中
                if (dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break; // 找到一种可行拆分就够了，不用继续试其他j
                }
            }
        }
        return dp[n];
    }


}
