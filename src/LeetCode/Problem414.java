package LeetCode;

import java.util.*;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/11 18:39
 * @desc:力扣第414题：第三大的数字
 */
public class Problem414 {
    public static void main(String[] args) {
        int[] nums={1,2,3,9};
        Problem414 p414 = new Problem414();
        System.out.println(p414.thirdMax1(nums));
        System.out.println(p414.thirdMax2(nums));
    }
    //方法一—：倒序遍历
    public int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
                if (count == 3) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];
    }
    //方法二：去重集合
    public int thirdMax2(int[] nums){
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size()>3){
                set.remove(set.first());
            }
        }
        return set.size()==3?set.first():set.last();
    }
}

