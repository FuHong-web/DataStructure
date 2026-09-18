package LeetCode_Revice5.dongtaiguihua;
/*爬楼梯*/
public class p70 {
    public int climbStairs(int n) {
        int p = 0,q = 0,r=1;
        for (int i = 1; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
