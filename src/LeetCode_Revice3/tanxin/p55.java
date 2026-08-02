package LeetCode_Revice3.tanxin;
/*跳崖游戏*/
public class p55 {
    public boolean canJump(int[] nums) {
        int maxRecah = 0;
        int n = nums.length;
        for(int i =0;i<n;i++) {
            if (i>maxRecah){
                return false;
            }
                maxRecah = Math.max(maxRecah,i+nums[i]);
            if (maxRecah > n-1) {
                return true;
            }
        }
        return true;
    }
}
