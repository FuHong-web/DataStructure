package LeetCode;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/9 21:39
 * @desc:力扣第268题丢失的数字
 */
public class Problem268 {
    public static void main(String[] args) {
        int[] nums={0,1,2,3,5,6,7};
        System.out.println(missingNumber1(nums));
        System.out.println(missingNumber2(nums));
    }
    //方法一
    public static int missingNumber1(int[] nums){
        Arrays.sort(nums);
        if (nums==null){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
           if (nums[i]!=i){
               return i;
           }
        }
        return nums.length;
    }
    //方法二
    public static int missingNumber2(int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }
}


