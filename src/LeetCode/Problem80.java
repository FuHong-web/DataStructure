package LeetCode;
/*删除有序数组的重复项*/
public class Problem80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <=2){
            return nums.length;
        }
        int slow = 2;
        for(int fast = 2;fast < nums.length;fast++){
            if(nums[slow -2] != nums[fast]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
