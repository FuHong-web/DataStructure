package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/22 22:24
 * @desc:力扣第198题:打家劫舍（动态规划）
 * dp[n] = MAX( dp[n-1], dp[n-2] + num )
 */
public class Problem198 {
    public int rob(int[] nums) {
        int n=nums.length;
        //dp数组长度为1.dp[0]表示表示0间房 dp[1]表示第1间房
        int[] dp=new int[n+1];
        if (n>0){
            dp[1]=nums[0];
        }
        for (int i=2;i<=n;i++){
            //两种选择
            //不抢第i间房 dp[i-1]
            //抢第i间房 dp[i-2]+nums[i-1]
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}
