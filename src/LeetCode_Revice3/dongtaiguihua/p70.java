package LeetCode_Revice3.dongtaiguihua;
/*爬楼梯*/
/*

爬楼梯递推公式：f(n) = f(n-1)+f(n-2)。
只用两个变量保存前两项，循环不断算出当前项；
每次计算完成后滑动窗口更新：把旧的前一项赋值给前前项，最新结果变成新的前一项，持续迭代直到算出 f (n)。
* 旧的【前一项 b】 → 变成新的【前前项 a】
刚算出的【当前项 c】 → 变成新的【前一项 b】
* */
public class p70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b= 2;
        int c= 0;
        for (int  i = 0;i<=n;i++) {
            c= a+b;
            a = b;
            b = c;
        }
        return c;
    }

}
