package LeetCode_Revice2.dongtaiguihua;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/14 23:43
 * @desc:单词拆分
 *
 * 想象你有一把尺子，从字符串开头开始量：
 *
 * 你站在位置 j（已经确定 0~j 这一段能拼出来）
 *
 * 然后你往右看，如果 j~i 这一段正好在词典里，那你就往前推进到位置 i
 *
 * dp[i] 的意思就是：前 i 个字符能不能被拼出来。
 *
 * 我在位置 i 停下来问自己：
 * “有没有一个 j，让我前面 0~j 已经能拼出来，并且 j~i 这段刚好是一个单词？”
 * 如果有，那 0~i 就能拼出来。
 */
public class p139 {
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
