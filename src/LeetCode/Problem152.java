package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/13 22:28
 * @desc:152. 乘积最大子数组（动态规划）
 */
public class Problem152 {
    public int maxProduct(int[] nums) {
        int mn=nums[0];
        int mx=nums[0];
        int ans=mx;
        for (int i = 1;i < nums.length;i++) {
            int cur = nums[i];
            int a = cur;
            int b = cur * mn;
            int c = cur * mx;
            int newMn = Math.min(a,Math.min(b,c));
            int newMx = Math.max(a,Math.max(b,c));
            mn=newMn;
            mx=newMx;
            ans=Math.max(ans,mx);
        }
        return ans;
    }
}
