package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/9 20:13
 * @desc:力扣第217题数组知否存在重复元素（利用Set不能存放重复元素）
 */
public class Problem217 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,3,6};
        System.out.println(containsDuplicate1(nums));
        System.out.println(containsDuplicate2(nums));
    }
    //方法一:HashsSet
    public static boolean containsDuplicate1(int[] nums){
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
    //方法二:排序找重复
    public static boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
