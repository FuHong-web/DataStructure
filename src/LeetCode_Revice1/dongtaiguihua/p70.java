package LeetCode_Revice1.dongtaiguihua;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/16 23:38
 * @desc:爬楼梯
 *
 * r = 1 = 爬到第 0 阶楼梯的方法数（站在原地，1 种方法）
 * 第 0 阶：r = 1
 * 第 1 阶：需要循环 第 1 次
 * 第 2 阶：需要循环 第 2 次
 * ...
 * 第 n 阶：需要循环 第 n 次
 */
public class p70 {
    public int climbStairs(int n) {
        int r = 1;
        int p = 0;
        int q = 0;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r =  p + q;
        }
        return r;
    }

}
