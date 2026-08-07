package LeetCode_Revice3.shuangzhizhen;
/*乘最多水的容器*/
/*盛水容器：看当下两根柱子，算矩形面积，抛弃矮柱子找更大容器；
接雨水：记两边最高围墙，围墙哪边矮，就算当前这一列能存多少雨水。*/
public class p11 {
    public int maxArea(int[] height) {
        int left=0;
        int right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea,(right-left)*Math.max(height[left],height[right]));
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
