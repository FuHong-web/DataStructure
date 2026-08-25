package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/20 17:21
 * @desc:力扣第189题（找规律求模）
 */
public class Problem189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i+k)%n] = nums[i];
        }
        System.arraycopy(temp,0,nums,0,n);
    }
}
