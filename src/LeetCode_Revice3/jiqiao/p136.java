package LeetCode_Revice3.jiqiao;
/*只出现一次的数*/
public class p136 {
    public int singleNumber(int[] nums){
        int ans=0;
        for (int num : nums) {
            ans^=num;
        }
        return ans;
    }
}
