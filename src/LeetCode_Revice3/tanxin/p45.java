package LeetCode_Revice3.tanxin;
/*跳跃游戏ii*/
public class p45 {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int minJumps = 0;
        while (right < nums.length-1) {
            int farest = 0;
            for(int i = left;i<=right;i++) {
                farest = Math.max(farest,nums[i]+i);
            }
            left = right+1;
            right = farest;
            minJumps++;

        }
        return minJumps;
}}
