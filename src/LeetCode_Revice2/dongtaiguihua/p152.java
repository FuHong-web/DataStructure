package LeetCode_Revice2.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/15 22:46
 * @desc:乘积最大的子数组
 */
public class p152 {
    public int maxProduct(int[] nums) {
        int maxnums = nums[0];
        int minnums = nums[0];
        int ans = maxnums;
        for (int i = 1;i < nums.length;i++) {
            int cur = nums[i];
            int a = cur;
            int b = cur * maxnums;
            int c = cur * minnums;
            int newMaxNums = Math.max(a,Math.max(b,c));
            int newMinNums = Math.min(a,Math.min(b,c));
            maxnums = newMaxNums;
            minnums = newMinNums;
            ans = Math.max(maxnums,ans);
        }
        return ans;
    }
}
