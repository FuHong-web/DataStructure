package LeetCode_Revice.jiqiao;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/10 22:15
 * @desc:寻炸重复数
 * 为什么能把数组当成链表？
 * 下标连续，且 nums 的值永远是合法下标，天然构成单向链表。
 * 为什么第二次同速走，相遇点一定是环入口？
 * 这是数学结论：快慢指针第一次相遇后，将一个指针放回起点，两者同速前进，必然在环入口相遇。
 */
public class p287 {
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
