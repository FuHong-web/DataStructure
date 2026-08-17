package LeetCode_Revice4.shuangzhizhen;
/*成最多水的容器*/
public class p11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left < right){
            maxArea = Math.max(maxArea,(right-left) * Math.min(height[left],height[right]));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
