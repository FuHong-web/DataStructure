package Revice2.shuzu;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/25 21:54
 * @desc:除自身以外的数组的乘积
 */
public class p238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // L[i]：i 左边所有数字的乘积
        int[] L = new int[len];
        // R[i]：i 右边所有数字的乘积
        int[] R = new int[len];

        // 第一个元素左边没有数，乘积为1
        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        // 最后一个元素右边没有数，乘积为1
        R[len - 1] = 1;
        for (int j = len - 2; j >= 0; j--) {
            R[j] = R[j + 1] * nums[j + 1];
        }

        // 当前位置结果 = 左边乘积 × 右边乘积
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}
