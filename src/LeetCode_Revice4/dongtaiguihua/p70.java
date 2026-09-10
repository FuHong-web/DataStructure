package LeetCode_Revice4.dongtaiguihua;
/*爬楼梯*/
public class p70 {
    public int climbStairs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int a= 1;
        int b =2;
        int c =0;
        for(int i =3;i <= n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
