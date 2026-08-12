package LeetCode_Revice3.jiqiao;
/*颜色分类*/
public class p75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                swap(nums,i,cur);
                cur++;
            }
        }
        for (int i = cur;i<n;i++){
            if(nums[i] == 1){
                swap(nums,i,cur);
                cur++;
            }
        }
    }
    private void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
