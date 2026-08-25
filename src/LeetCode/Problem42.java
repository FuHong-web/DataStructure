package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/5 19:14
 * @desc:第42题：接雨水（双指针）单个位置能存的水 = min(左侧最高墙, 右侧最高墙) - 当前高度
 */
public class Problem42 {
    public int trap(int[] height) {
      int left = 0;
      int right = height.length-1;
      int lmax = height[left];
      int rmax = height[right];
      int ans = 0;
      while (left < right){
          lmax = Math.max(lmax,height[left]);
          rmax = Math.max(rmax,height[right]);
          if(lmax < rmax){
              ans += (lmax - height[left]);
              left++;
          }else {
              ans += (rmax - height[right]);
              right--;
          }
      }
      return ans;
}}
