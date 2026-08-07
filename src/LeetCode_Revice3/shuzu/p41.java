package LeetCode_Revice3.shuzu;

import java.util.Arrays;

/*数组缺失的第一个正数*/
public class p41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        for (int x : nums) {
            if (x == ans) ans++;
            else if (x > ans) break;
        }
        return ans;
    }
}
