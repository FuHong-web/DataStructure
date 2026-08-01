package LeetCode_Revice3.dongtaiguihua;

import java.util.Map;

/*乘积最大得子数组*/
public class p152 {
    class Solution {

        public int maxProduct (int [] nums) {
            int ans = nums[0];
            int max = nums[0];
            int min = nums[0];
            for (int i =1;i<nums.length;i++) {
                int a = nums[i];
                int b= a * max;
                int c = a * min;
                int newMax = Math.max(a,Math.max(b,c));
                int newMin = Math.min(a,Math.min(b,c));
                max = newMax;
                min = newMin;
                ans = Math.max(ans,max);
            }
            return ans;
        }

    }
}
