package LeetCode_Revice4.shuzu;

import java.util.Arrays;

/*确实的第一个正数*/
public class p41 {
    public int firstMissingPositive(int[] nums){
        int ans  =1;
        Arrays.sort(nums);
        for (int num : nums) {
            if(ans == num){
                ans++;
            }else if(num > ans){
                break;
            }
        }
        return ans;
    }
}
