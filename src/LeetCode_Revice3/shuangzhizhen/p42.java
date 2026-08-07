package LeetCode_Revice3.shuangzhizhen;

/*盛水容器：看当下两根柱子，算矩形面积，抛弃矮柱子找更大容器；
接雨水：记两边最高围墙，围墙哪边矮，就算当前这一列能存多少雨水。*/
/*接雨水*/
public class p42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int lMax = 0;
        int rMax = 0;
        int ans = 0;
        while (left<right){
            lMax = Math.max(lMax,height[left]);
            rMax = Math.max(rMax,height[right]);
            if (lMax < rMax){
                ans  += (lMax-height[left++]);
            }else {
                ans+= (rMax-height[right--]);
            }
        }
        return  ans;
    }
}
