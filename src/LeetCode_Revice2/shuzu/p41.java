package LeetCode_Revice2.shuzu;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/25 22:09
 * @desc:缺失第一个正数
 */
public class p41 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> op = new HashSet<>();
        for (int num : nums) {
            op.add(num);
        }
        int target = 1;
        while (op.contains(target)) {
            target++;
        }
        return target;
    }
}
