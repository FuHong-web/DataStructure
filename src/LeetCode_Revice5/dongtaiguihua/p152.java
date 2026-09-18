package LeetCode_Revice5.dongtaiguihua;

import com.sun.tools.javac.Main;

import java.awt.event.MouseAdapter;

/*乘积最大的子数组和*/
public class p152 {
    public int maxProduct(int[] nums){
        int max = nums[0];
        int min = nums[0];
        int ans= max;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int a = cur;
            int b = cur * max;
            int c = cur * min;
            int newMax = Math.max(a,Math.max(b,c));
            int newMin = Math.min(a,Math.max(b,c));
            max = newMax;
            min = newMin;
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
