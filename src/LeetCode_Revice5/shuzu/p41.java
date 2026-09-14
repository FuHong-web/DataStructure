package LeetCode_Revice5.shuzu;

import java.util.Arrays;

/*缺失的第一个整数*/
public class p41 {
    public int queshiFirst(int[] nums){
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if(ans == nums[i]){
                ans++;
            }else if (nums[i] > ans){
                break;
            }
        }
        return ans;
    }
}
