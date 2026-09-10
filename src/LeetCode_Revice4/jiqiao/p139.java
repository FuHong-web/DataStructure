package LeetCode_Revice4.jiqiao;
/*只出现一次的数字*/
public class p139 {
    public int singleNumber(int[] nums){
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
