package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/11 0:07
 * @desc:力扣第283题：移动零（双指针）
 */
public class Problem283_2 {
    public void moveZeroes(int[] nums) {
        if (nums==null){
            return;
        }
        int j=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for (int m = j; m < nums.length; m++) {  // 从位置 j 开始
            nums[m] = 0;
        }
    }
}
