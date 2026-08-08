package LeetCode_Revice3.erfenchazhao;
/*旋转排序数组的最小值*/
public class p153 {  public int findMin(int[] nums) {
    int left = 0;
    int right= nums.length-1;
    while (left < right){
        int mid = left + (right-left)/2;
        if(nums[mid] > nums[right]){//小值段在右边，去右边找
            left = mid+1;
        }else {
            right = mid;
        }
    }
    return nums[left];
}
}
