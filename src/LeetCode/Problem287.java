package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/29 23:11
 * @desc:寻找重复数（快慢指针）
 */
public class Problem287 {
    public int findDuplicate(int[] nums) {
        // 1. 快慢指针相遇，找到环中的某一点
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];         // 慢指针：每次走1步
            fast = nums[nums[fast]];   // 快指针：每次走2步
            if (slow == fast) {
                break;
            }
        }

        // 2. 快指针回到起点，两个指针同速前进，相遇点即为环的入口（重复数）
        fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) {
                return slow;
            }
        }
    }
}
