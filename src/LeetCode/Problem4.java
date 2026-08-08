package LeetCode;
/*
* 先牢牢记住前提：
我们已经固定了 i + j = half = (m+n+1)/2，j 完全由 i 决定，只要 i 确定，j 就被唯一锁死。
四个值：left1、right1、left2、right2。
1. 合法条件：left1 <= right2 && left2 <= right1
切割有效，满足：
左半边所有数字 ≤ 右半边所有数字。
此时直接计算中位数，结束循环。
2. 整个区间只会出现两种不合法的情况
两个不等式 left1 <= right2、left2 <= right1，只会有两种不合法组合：
情况 A：left1 > right2
也就是：nums1 左边的最大值，比 nums2 右边最小值还要大。
含义：nums1 左边元素太大了，分割线 i 需要往左收缩（hi = i - 1），从 nums1 左侧拿走一部分元素丢去右边。
情况 B：left2 > right1
也就是：nums2 左边的最大值，比 nums1 右边最小值还要大。
结合 i+j=定值 的关系：
left2 > right1 等价于 left1 <= right2 必然成立。
这种情况，需要把 nums1 的分割线往右移动（lo = i + 1），多拿一些 nums1 的元素放到左侧，从而让 nums2 左侧少拿元素、修正 left2。*/
/**
 * @author: Yan Tong xue
 * @Created:2026/4/26 20:22
 * @desc:寻找两个正序数组的中位数（二分递归）
 */
public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      if(m>n){
          int[] temp = nums1;
          nums1 = nums2;
          nums2 = temp;
      }
      int low = 0;
      int high = m;
      while (low<=high){
          int i= (low+high) / 2;
          int j = (m+n +1) -i;
          int left1 = (i==0) ? Integer.MIN_VALUE : nums1[i-1];
          int right1 = (i==m) ? Integer.MAX_VALUE : nums1[i];
          int left2 = (j==0) ? Integer.MIN_VALUE : nums2[j-1];
          int right2 = (i==n) ? Integer.MAX_VALUE : nums2[j];

          if(left1 <= right2 && left2 <= right1){
              if((m+n) % 2== 0){
                  return (Math.max(left1,left2)+Math.min(right1,right2));
              }else {
                  return Math.max(left1,left2);
              }
          } else if (left1 > right2) {
                high = i-1;
          }else {
              low = j+1;
          }
      }
      return 0.0;
    }
}
