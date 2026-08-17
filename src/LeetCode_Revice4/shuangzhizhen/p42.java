package LeetCode_Revice4.shuangzhizhen;

/*接雨水*/
public class p42 {
    
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans =0;
        int lMax = 0;
        int rMax = 0;
        while (left < right){
            lMax = Math.max(lMax,height[left]);
            rMax = Math.max(rMax,height[right]);
            if(lMax < rMax){
                ans += lMax - height[left++];
            }else {
                ans += rMax - height[right--];
            }
        }
        return ans;
    }
}
