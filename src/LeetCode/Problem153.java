package LeetCode;
/*
* 模板 1：查找某个确定值（存在就返回下标）
循环条件：while(left <= right)
收缩规则：一定 left=mid+1 / right=mid-1，丢弃 mid。
适用场景：普通二分、搜索旋转数组 33 题。
模板 2：寻找分界点、最小值、左边界、第一个满足条件的位置
循环条件：while(left < right)
收缩规则：有一侧保留 mid（right=mid），防止丢掉答案。
适用场景：旋转找最小值 153、寻找左边界、查找第一个≥target 的数。
* */
/**
 * @author: Yan Tong xue
 * @Created:2026/5/30 23:56
 * @desc:寻找旋转数组的最小值
 */
public class Problem153 {
    public int findMin(int[] nums) {
       int left = 0;
       int right= nums.length-1;
       while (left < right){
           int mid = left + (right-left)/2;
           if(nums[mid] > nums[right]){
               left = mid+1;
           }else {
               right = mid;
           }
       }
       return nums[left];
}
}
