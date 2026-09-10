package LeetCode_Revice5.shuangzhizhen;
/*接雨水*/
public class p42 {
    public int maxArea(int[] nums){
        int ans = 0;
        int lMax= 0;
        int rMax = 0;
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            lMax = Math.max(lMax,nums[left]);
            rMax = Math.max(rMax,nums[right]);
            if(lMax < rMax){
                ans += lMax-nums[left++];
            }else {
                ans += rMax - nums[right--];
            }
        }
        return ans;
    }
}
