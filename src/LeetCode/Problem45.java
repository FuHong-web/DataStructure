package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/15 22:04
 * @desc:跳跃游戏II()
 */
public class Problem45 {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int min_jumps = 0;
        while (right < nums.length-1) {
            int farthest = 0;
            for (int i = left;i <= right;i++) {
                farthest = Math.max(farthest,i+nums[i]);
            }
            left = right+1;
            right = farthest;
            min_jumps++;
        }
        return min_jumps;
    }
}
