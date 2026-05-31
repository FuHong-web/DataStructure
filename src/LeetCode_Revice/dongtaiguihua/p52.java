package LeetCode_Revice.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/21 22:44
 * @desc:
 */
public class p52 {
    public int maxProduct(int[] nums) {
        int mn = nums[0];  // 当前最小乘积
        int mx = nums[0];  // 当前最大乘积
        int ans = mx;      // 答案

        // 注意：i 从 1 开始
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            // 三个候选值！！！关键
            int a = cur;
            int b = cur * mn;
            int c = cur * mx;

            // 新的最小、最大
            int newmn = Math.min(a, Math.min(b, c));
            int newmx = Math.max(a, Math.max(b, c));

            mn = newmn;
            mx = newmx;

            ans = Math.max(ans, mx);
        }
        return ans;
    }
}
