package LeetCode_Revice.jiqiao;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/9 22:01
 * @desc:只出现一次的数字
 * 0 ^ 任何数 = 这个数本身
 * 相同数异或 = 0
 */
public class p136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
