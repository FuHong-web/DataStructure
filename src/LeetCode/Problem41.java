package LeetCode;

import java.util.Arrays;
/*
* 先把数组升序排序，从小到大遍历。
如果遍历到的数 x 正好等于我期待的 ans：说明这个正数存在，期待下一个，ans++。
如果遍历到 x > ans：后面全部数字都比 ans 更大，ans 一定缺失，直接 break 返回 ans。
如果 x < ans（负数、0、重复数字）：什么都不做，直接跳过。
* */
/**
 * @author: Yan Tong xue
 * @Created:2026/4/25 10:59
 * @desc:缺失的第一个正整数（数组交换）
 */
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        for (int x : nums) {
            if (x == ans) {
                ans++;
            }else if (x > ans){
                break;
            }
        }
        return ans;
    }
}
