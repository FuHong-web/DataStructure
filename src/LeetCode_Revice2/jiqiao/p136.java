package LeetCode_Revice2.jiqiao;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/13 17:57
 * @desc:只出现一次的数字
 */
public class p136 {
    public int singleNumber(int[] nums){
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
