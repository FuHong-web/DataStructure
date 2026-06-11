package LeetCode_Revice.jiqiao;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/9 22:15
 * @desc:
 */
public class p169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }
}
