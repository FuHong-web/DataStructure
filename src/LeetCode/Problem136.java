package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/12 10:58
 * @desc:力扣第136题：只出现一次的数字（位运算）
 * ^异或：相同为0就抵消了
 * [2,2,3]=>0 ^ 2 ^ 3 ^ 2 = 0 ^ (2 ^ 2) ^ 3 = 0 ^ 0 ^ 3 = 3中的(2 ^ 2)就为0，相当于不存在了，然后只出现一次的3和ans初始值0做抑或就等于3本身
 */
public class Problem136 {
    public int singleNumber(int[] nums){
        int ans=0;
        for (int num : nums) {
            ans^=num;
        }
        return ans;
    }
}
