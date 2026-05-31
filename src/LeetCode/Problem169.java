package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/17 9:23
 * @desc:力扣第169题
 */
public class Problem169 {
    public int majorityElement(int[] nums) {
        int count=0;
        int candidate=0;
        for (int num : nums) {
            if (count==0){
                candidate=num;
            }
            if (num==candidate){
                count+=1;
            }else {
                count-=1;
            }
        }
        return candidate;
    }
}
